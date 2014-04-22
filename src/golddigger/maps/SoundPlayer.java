/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.maps;

import golddigger.abstracts.AbsMovingObject;
import golddigger.abstracts.EnActionResult;
import golddigger.abstracts.IntMoveResultListener;
import golddigger.abstracts.IntSoundObject;

/**
 *
 * @author alexkurocha
 */
public class SoundPlayer implements IntMoveResultListener {

    @Override
    public void moveActionPerformed(EnActionResult actionResult, AbsMovingObject movingObject) {
        if (!(movingObject instanceof IntSoundObject)) {
            return;
        }
        IntSoundObject so = (IntSoundObject) movingObject;
        playSound(so.getSoundPath(actionResult), false, true);
        
        
    }
    
    public void playSound(String soundFilePath, final boolean isLoopping, final boolean isStopPrevious) {
        System.out.println("Playing " + soundFilePath);
    }
    
}
