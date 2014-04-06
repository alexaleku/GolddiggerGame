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
    private final String iconPathUp = "/golddigger/images/Iron_Man_up.png";
    private final String iconPathDown = "/golddigger/images/Iron_Man_down.png";
    private final String iconPathRight = "/golddigger/images/Iron_Man_right.png";
    private final String iconPathLeft = "/golddigger/images/Iron_Man_left.png";

    private String imagePath = "/golddigger/images/Iron_Man_down.png";
    private int totalScore = 0;
    private int turnsNumber = 0;

    public Golddigger(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setImageIcon(getImageIcon(imagePath));
        
       super.setIconUp(getImageIcon(iconPathUp));
        super.setIconDown(getImageIcon(iconPathDown));
        super.setIconRight(getImageIcon(iconPathRight));
        super.setIconLeft(getImageIcon(iconPathLeft));

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
