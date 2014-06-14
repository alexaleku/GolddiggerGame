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
public abstract class AbsScoreManager implements IntScoreManager {

    private UserScore userScore;

    public void saveScore() {
        saveScore(userScore);
    }

    public UserScore getUserScore() {
        return userScore;
    }

    public void setUserScore(UserScore userScore) {
        this.userScore = userScore;
    }
}
