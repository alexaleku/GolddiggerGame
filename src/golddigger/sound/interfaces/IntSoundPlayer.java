/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.sound.interfaces;

import javax.sound.sampled.Clip;

/**
 *
 * @author alexkurocha
 */
public interface IntSoundPlayer {
    void playSound(Clip clip, final boolean loop);
    
    void startBackgroundMusic(String soundName);

    void stopBackgoundMusic();
}
