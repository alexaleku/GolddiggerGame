/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.abstracts.AbsGameObject;
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
    public void move(EnMovingDiraction derection) {
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
