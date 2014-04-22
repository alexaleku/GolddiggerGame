/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.mapobjects;

import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.AbsMovingObject;
import golddigger.abstracts.EnActionResult;
import golddigger.abstracts.EnMovingDirection;
import golddigger.abstracts.IntSoundObject;

/**
 *
 * @author alexkurocha
 */
public class Golddigger extends AbsMovingObject implements IntSoundObject {

    private final String iconPathUp = "/golddigger/images/Iron_Man_up.png";
    private final String iconPathDown = "/golddigger/images/Iron_Man_down.png";
    private final String iconPathRight = "/golddigger/images/Iron_Man_left.png";
    private final String iconPathLeft = "/golddigger/images/Iron_Man_right.png";

    private String imagePath = "/golddigger/images/Iron_Man_down.png";
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

    @Override
    public void changeIcon(EnMovingDirection direction) {
        switch (direction) {
            case UP: {
                super.setImageIcon(getImageIcon(iconPathUp));
                break;
            }
            case DOWN: {
                super.setImageIcon(getImageIcon(iconPathDown));
                break;
            }
            case LEFT: {
                super.setImageIcon(getImageIcon(iconPathRight));
                break;
            }
            case RIGHT: {
                super.setImageIcon(getImageIcon(iconPathLeft));
                break;
            }
        }
    }

    @Override
    public EnActionResult doAction(AbsGameObject objectInNewCoord) {
        turnsNumber++;

        System.out.println(objectInNewCoord);

        switch (objectInNewCoord.getType()) {

            case TREASURE: {
                totalScore += ((Treasure) objectInNewCoord).getScore();
                return EnActionResult.COLLECT_TREASURE;
            }

            case MONSTER: {
                return EnActionResult.DIE;
            }

            case EXIT: {
                totalScore *= 2;
                return EnActionResult.WIN;
            }
        }

        return super.doAction(objectInNewCoord);
    }

    @Override
    public String getSoundPath(EnActionResult actionResult) {
        switch (actionResult) {

            case WIN: {
                return "WIN SOUND";
            }

            case DIE: {
                return "DIE SOUND";
            }
        }
        return null;
    }
}
