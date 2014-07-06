/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author alexkurocha
 */
public abstract class ConfirmCloseFrame extends BaseForChilds {

    protected abstract boolean acceptCloseAction();

    @Override
    protected void setCloseOperation() {
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        super.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (acceptCloseAction()) {
                    closeFrame();
                }
            }
        });
    }
}
