/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.users;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author alexkurocha
 */
public class DbScoreManager extends AbsScoreManager {
    private Connection con;
    private String path = "";
    
    @Override
    public boolean saveScore(UserScore userScore) {
        return false;
    }

    @Override
    public ArrayList<UserScore> getScoreList() {
        return null;
    }
    
}
