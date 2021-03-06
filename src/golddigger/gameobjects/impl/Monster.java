/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.gameobjects.impl;

import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.gameobjects.abstracts.AbsMovingObject;
import golddigger.enums.EnActionResult;
import golddigger.enums.EnGameObjectType;
import golddigger.enums.EnMovingDirection;
import golddigger.gameobjects.abstracts.AbsSoundObject;
import golddigger.gameobjects.interfaces.IntSoundObject;
import javax.sound.sampled.Clip;

/**
 *
 * @author alexkurocha
 */
public class Monster extends AbsSoundObject implements IntSoundObject {

    private final String iconPathUp = "/golddigger/images/red_monster_up.png";
    private final String iconPathDown = "/golddigger/images/red_monster_down.png";
    private final String iconPathRight = "/golddigger/images/red_monster_right.png";
    private final String iconPathLeft = "/golddigger/images/red_monster_left.png";

    public Monster(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setImageIcon(getImageIcon(iconPathDown));
        super.setType(EnGameObjectType.MONSTER);
    }

    @Override
    public void changeIcon(EnMovingDirection direction) {
        switch (direction) {
            case UP: {
                setImageIcon(getImageIcon(iconPathUp));
                break;
            }
            case DOWN: {
                setImageIcon(getImageIcon(iconPathDown));
                break;
            }
            case LEFT: {
                setImageIcon(getImageIcon(iconPathLeft));
                break;
            }
            case RIGHT: {
                setImageIcon(getImageIcon(iconPathRight));
                break;
            }
        }
    }

    public EnActionResult doAction(AbsGameObject gameObject) {
        switch (gameObject.getType()) {
            case TREASURE:
            case MONSTER:
                return EnActionResult.NO_ACTION;
            case GOLDDIGGER:
                return EnActionResult.DIE;
        }
        return super.doAction(gameObject);

    }

    @Override
    public Clip getSoundClip(EnActionResult actionResult) {
        switch (actionResult) {
            case DIE: {
                return super.getDieClip();
            }
        }
        return null;
    }

}
