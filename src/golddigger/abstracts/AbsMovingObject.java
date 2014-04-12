/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.abstracts;

import static golddigger.abstracts.EnMovingDirection.DOWN;
import static golddigger.abstracts.EnMovingDirection.LEFT;
import static golddigger.abstracts.EnMovingDirection.RIGHT;
import static golddigger.abstracts.EnMovingDirection.UP;
import golddigger.mapobjects.Coordinate;
import javax.swing.ImageIcon;

/**
 *
 * @author alexkurocha
 */
public abstract class AbsMovingObject extends AbsGameObject implements IntMovingObject {

    private ImageIcon iconUp;
    private ImageIcon iconDown;
    private ImageIcon iconRight;
    private ImageIcon iconLeft;

    protected abstract void changeIcon(EnMovingDirection direction);

    public EnActionResult moveToObject(EnMovingDirection direction, AbsGameObject objectInNewCoord) {
        changeIcon(direction);
           if (objectInNewCoord == null) {
            return EnActionResult.NO_ACTION;
        }
        return doAction(objectInNewCoord);

    }

    public EnActionResult doAction(AbsGameObject objectInNewCoord) {

     
        switch (objectInNewCoord.getType()) {
            case NOTHING: {
                return EnActionResult.MOVE;
            }
        }

        return EnActionResult.NO_ACTION;
    }
}
