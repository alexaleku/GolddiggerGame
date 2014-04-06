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

    @Override
    public void move(EnMovingDirection direction) {
         // берем текущие координаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);

        switch (direction) {   // определяем, в каком направлении нужно двигаться по массиву
            case UP: {
                super.setImageIcon(getIconUp());
                newCoordinate.setXY(x, y - 1);
                break;
            }
            case DOWN: {
                super.setImageIcon(getIconDown());
                newCoordinate.setXY(x, y + 1);
                break;
            }
            case LEFT: {
                super.setImageIcon(getIconLeft());
                newCoordinate.setXY(x - 1, y);
                break;
            }
            case RIGHT: {
                super.setImageIcon(getIconRight());
                newCoordinate.setXY(x + 1, y);
                break;
            }
        }

        setCoordinate(newCoordinate);
        
    }

    public ImageIcon getIconUp() {
        return iconUp;
    }

    public ImageIcon getIconDown() {
        return iconDown;
    }

    public ImageIcon getIconRight() {
        return iconRight;
    }

    public ImageIcon getIconLeft() {
        return iconLeft;
    }

    public void setIconUp(ImageIcon iconUp) {
        this.iconUp = iconUp;
    }

    public void setIconDown(ImageIcon iconDown) {
        this.iconDown = iconDown;
    }

    public void setIconRight(ImageIcon iconRight) {
        this.iconRight = iconRight;
    }

    public void setIconLeft(ImageIcon iconLeft) {
        this.iconLeft = iconLeft;
    }

}
