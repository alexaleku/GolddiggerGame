/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

/**
 *
 * @author alexkurocha
 */
public interface IntSoundPlayer {
    void playSound(String soundFilePath, final boolean isLoopping, final boolean isStopPrevious);
    
    void startBackgroundMusic(String soundName);

    void stopBackgoundMusic();
}
