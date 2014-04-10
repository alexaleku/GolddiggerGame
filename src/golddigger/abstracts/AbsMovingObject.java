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

    @Override
    public void move(AbsGameMap gameMap, EnMovingDirection direction) {
        
        
        Coordinate newCoordinate = getMoveTargetCoord(direction);
        AbsGameObject objInNewCoord = gameMap.getGameCollection().getObjByCoord(newCoordinate);
        if (objInNewCoord.getType() == EnGameObjectType.NOTHING) {
            changeIcon(direction);
            setCoordinate(newCoordinate);
        }
        
    }

    private Coordinate getMoveTargetCoord(EnMovingDirection direction) {
        // берем текущие координаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();
        
        
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
