/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.score.impl;

import golddigger.score.abstracts.AbsScoreManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexkurocha
 */
public class DbScoreManager extends AbsScoreManager {

    private Connection con;
    private String pathToDB = "/db/golddigger.sqlite";

    public DbScoreManager() {
    }

    @Override
    public boolean saveScore(UserScore userScore) {
        try {
            getConnection().setAutoCommit(false);
            if (saveAll(userScore)) {
                getConnection().commit();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnecton();
        }
        return false;
    }

    @Override
    public ArrayList<UserScore> getScoreList() {
        PreparedStatement selectStmt = null;
        ArrayList<UserScore> userScoreList = new ArrayList<UserScore>();
        ResultSet rs = null;
        try {
            selectStmt.getConnection().prepareStatement("select count(s.score) as play_count, s.score, s.play_date, p.username from score s inner join player p on p.id = s.player_id where s.score>0 group by p.username order by s.score desc, play_count asc limit 10");
            rs = selectStmt.executeQuery();

            while (rs.next()) {
                UserScore userScore = new UserScore();
                userScore.setPlayDate(rs.getLong("play_date"));
                userScore.setScore(rs.getInt("score"));
                userScore.setUserName(rs.getString("username"));
                userScore.setPlayCount(rs.getInt("play_count"));

                userScoreList.add(userScore);
            }
        } catch (Exception e) {
        }

        return userScoreList;
    }

    private Connection getConnection() {

        try {
            if (con == null) {
                Class.forName("org.sqlite.JDBC").newInstance();
                String url = "jdbc:sqlite:" + pathToDB;
                con = DriverManager.getConnection(url);
            }
            return con;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private boolean saveAll(UserScore userScore) throws SQLException {
        PreparedStatement insertUserStmt = null;
        PreparedStatement selectStmt = null;
        PreparedStatement insertScoreStmt = null;

        int result = 0;
        try {
            int playerId = getPlayerById(userScore.getUserName());
            if (playerId == 0) {

                insertUserStmt = getConnection().prepareStatement("insert into player(username) values(?)");
                insertUserStmt.setString(1, userScore.getUserName());
                result = insertUserStmt.executeUpdate();
                if (result == 0) {
                    return false;
                }
                selectStmt = getConnection().prepareStatement("select last_insert_rowid()");
                playerId = selectStmt.executeQuery().getInt(1);
            }
            insertScoreStmt = getConnection().prepareStatement("insert into score(player_id, score, play_date) values(?,?,?)");
            insertScoreStmt.setInt(1, playerId);
            insertScoreStmt.setInt(2, userScore.getScore());
            insertScoreStmt.setLong(3, new Date().getTime());

            result = insertScoreStmt.executeUpdate();

            if (result == 0) {
                return false;
            }

            return true;

        } finally {
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (insertScoreStmt != null) {
                insertScoreStmt.close();
            }
            if (insertUserStmt != null) {
                insertUserStmt.close();
            }

        }
    }

    private void closeConnecton() {
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            Logger.getLogger(DbScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int getPlayerById(String username) throws SQLException {
        PreparedStatement selectStmt = null;

        try {

            selectStmt = getConnection().prepareStatement("select id from player where username = ?");
            selectStmt.setString(1, username);

            ResultSet result = selectStmt.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }

        } finally {
            if (selectStmt != null) {
                selectStmt.close();
            }
        }
        return 0;
    }
}
