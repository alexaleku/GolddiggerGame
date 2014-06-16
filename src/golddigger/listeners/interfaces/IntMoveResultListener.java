/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.listeners.interfaces;

import golddigger.enums.EnActionResult;
import golddigger.gameobjects.abstracts.AbsMovingObject;

/**
 *
 * @author alexkurocha
 */
public interface IntMoveResultListener {
    void moveActionPerformed(EnActionResult actionResult, AbsMovingObject movingObject);
    
}
