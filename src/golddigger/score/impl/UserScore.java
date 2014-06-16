/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.score.impl;

/**
 *
 * @author alexkurocha
 */
public class UserScore {
    private int id;
    private String userName;
    private int score;
    private long playDate;
    private int playCount;
    
    UserScore() {
    }

    public UserScore(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPlayDate() {
        return playDate;
    }

    public void setPlayDate(long playDate) {
        this.playDate = playDate;
    }
    
    
}
