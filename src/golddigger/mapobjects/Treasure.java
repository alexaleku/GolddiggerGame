/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.mapobjects;

import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.AbsGameObject;

/**
 *
 * @author alexkurocha
 */
public class Treasure extends AbsGameObject {
    private final String imagePath = "/golddigger/images/gold.png";
    private int score = 5;

    public Treasure(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(EnGameObjectType.TREASURE);
        super.setImageIcon(getImageIcon(imagePath));
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
