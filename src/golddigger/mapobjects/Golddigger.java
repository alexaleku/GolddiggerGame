/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.mapobjects;

import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.AbsMovingObject;

/**
 *
 * @author alexkurocha
 */
public class Golddigger extends AbsMovingObject {
    private String imagePath = "/golddigger/images/Iron_Man.png";
    private int totalScore = 0;
    private int turnsNumber = 0;

    public Golddigger(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setImageIcon(getImageIcon(imagePath));
        super.setType(EnGameObjectType.GOLDDIGGER);
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }
    
    
}
