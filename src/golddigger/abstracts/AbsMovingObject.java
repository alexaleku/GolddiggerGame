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
    
      public Coordinate getMoveTargetCoord(Coordinate oldCoordinate, EnMovingDirection direction) {
        // берем текущие коордthis.getCoordinate().getXинаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = oldCoordinate.getX();
        int y = oldCoordinate.getY();

        Coordinate newCoordinate = new Coordinate(x, y);

        switch (direction) {   // определяем, в каком направлении нужно двигаться по массиву
            case UP: {
                newCoordinate.setXY(x, y - 1);
                break;
            }
            case DOWN: {
                newCoordinate.setXY(x, y + 1);
                break;
            }
            case LEFT: {
                newCoordinate.setXY(x - 1, y);
                break;
            }
            case RIGHT: {
                newCoordinate.setXY(x + 1, y);
                break;
            }
        }
        return newCoordinate;
    }
}
