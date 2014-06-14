/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.users;

import java.util.ArrayList;

/**
 *
 * @author alexkurocha
 */
public interface IntScoreManager {

    boolean saveScore(UserScore userScore);

    ArrayList<UserScore> getScoreList();

}
