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
    private int step = 1;

    protected abstract void changeIcon(EnMovingDirection direction);

    @Override
    public EnActionResult moveToObject(EnMovingDirection direction, AbsGameObject objectInNewCoord) {
        actionBeforeMove(direction);
        return doAction(objectInNewCoord);  // this calls method doAction in child class if it's overwritten (if not it calls method in this class) 

    }

    private void actionBeforeMove(EnMovingDirection direction) {
        changeIcon(direction);
    }

    // this is called from overridden methods in child classes and functionality is used as defoults for action results (for Nothing and Wall objects)
    public EnActionResult doAction(AbsGameObject objectInNewCoord) {
        
         if (objectInNewCoord == null) {  // when out of the game border
            return EnActionResult.NO_ACTION;
        }
         
        switch (objectInNewCoord.getType()) {
            case NOTHING: {
                return EnActionResult.MOVE;
            }
            case WALL: {
                return EnActionResult.NO_ACTION; // ristriction to go through walls at this first lever
            }
        }
        return EnActionResult.NO_ACTION;
    }

    public Coordinate getMoveTargetCoord(EnMovingDirection direction) {
        // берем текущие коордthis.getCoordinate().getXинаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();

        Coordinate newCoordinate = new Coordinate(x, y);

        switch (direction) {   // shift coordinate in appropriate direction
            case UP: {
                newCoordinate.setXY(x, y - this.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setXY(x, y + this.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setXY(x - this.getStep(), y);
                break;
            }
            case RIGHT: {
                newCoordinate.setXY(x + this.getStep(), y);
                break;
            }
        }
        return newCoordinate;
    }

    @Override
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

}
