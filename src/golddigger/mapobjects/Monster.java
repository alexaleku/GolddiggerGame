/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.mapobjects;

import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.AbsMovingObject;
import golddigger.abstracts.EnActionResult;
import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.EnMovingDirection;
import golddigger.abstracts.IntSoundObject;

/**
 *
 * @author alexkurocha
 */
public class Monster extends AbsMovingObject implements IntSoundObject {

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
        switch(gameObject.getType()) {
            case TREASURE:
            case MONSTER:
                return EnActionResult.NO_ACTION;
            case GOLDDIGGER:
                return EnActionResult.DIE;
        }
        return super.doAction(gameObject);
        
    }
    
    @Override
    public String getSoundPath(EnActionResult actionResult) {
        switch (actionResult) {
            case DIE: {
                return "DIE SOUND";
            }
        }
        return null;
    }
    
    

}
