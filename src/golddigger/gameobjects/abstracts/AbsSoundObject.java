/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.gameobjects.abstracts;

import golddigger.gameobjects.interfaces.IntSoundObject;
import golddigger.sound.impl.SoundPlayerWav;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author alexkurocha
 */
public abstract class AbsSoundObject extends AbsMovingObject implements IntSoundObject {

    public transient Clip dieClip;

    public Clip getDieClip() {
        if (dieClip == null) {
            setDieClip();
        }
        return dieClip;
    }

    private void setDieClip() {
        dieClip = openClip(SoundPlayerWav.SOUND_DIE);
    }

    public Clip openClip(String soundName) {
        try {
            Clip clip = AudioSystem.getClip();
            URL resource = this.getClass().getResource(SoundPlayerWav.SOUND_PATH + soundName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(resource);
            clip.open(ais);
            return clip;
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(AbsSoundObject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
