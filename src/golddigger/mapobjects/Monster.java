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
public class Monster extends AbsMovingObject {
    private final String iconPathUp = "/golddigger/images/red_monster_up.png";
    private final String iconPathDown = "/golddigger/images/red_monster_down.png";
    private final String iconPathRight = "/golddigger/images/red_monster_right.png";
    private final String iconPathLeft = "/golddigger/images/red_monster_left.png";

    public Monster(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setImageIcon(getImageIcon(iconPathDown));
        super.setType(EnGameObjectType.MONSTER);
        
        super.setIconUp(getImageIcon(iconPathUp));
        super.setIconDown(getImageIcon(iconPathDown));
        super.setIconRight(getImageIcon(iconPathRight));
        super.setIconLeft(getImageIcon(iconPathLeft));
    
    }
}
