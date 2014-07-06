/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.sound.impl;

import golddigger.gameobjects.abstracts.AbsMovingObject;
import golddigger.enums.EnActionResult;
import golddigger.listeners.interfaces.IntMoveResultListener;
import golddigger.gameobjects.interfaces.IntSoundObject;
import golddigger.sound.interfaces.IntSoundPlayer;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 *
 * @author alexkurocha
 */
public class SoundPlayerWav implements IntMoveResultListener, IntSoundPlayer {

    public static final String SOUND_BACKGROUND = "background.wav";
    public static final String SOUND_DIE = "die.wav";
    public static final String SOUND_TREASURE = "treasure.wav";
    public static final String SOUND_WIN = "win.wav";
    public static final String SOUND_MOVE = "waka_waka.wav";

    public static final String SOUND_PATH = "/golddigger/sounds/files/";

    private Clip backGroundClip;

    public SoundPlayerWav() {
        try {
            backGroundClip = AudioSystem.getClip();
            URL resource = this.getClass().getResource(SOUND_PATH + SOUND_BACKGROUND);
            AudioInputStream ais = AudioSystem.getAudioInputStream(resource);
            backGroundClip.open(ais);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void moveActionPerformed(EnActionResult actionResult, AbsMovingObject movingObject) {
        if (!(movingObject instanceof IntSoundObject)) {
            return;
        }
        IntSoundObject so = (IntSoundObject) movingObject;
        Clip clip = so.getSoundClip(actionResult);
        playSound(clip, false);

    }

//    public static void startBackgroundMusic() {
//      backgroundMusic = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                new SoundPlayer().playSound("background music...", true, true); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        backgroundMusic.start();
//    }
//    public static void stopBeckgroundMusic() {
//        backgroundMusic.stop();
//    }
    public void playSound(final Clip clip, final boolean loop) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                if (clip == null) {
                    return;
                }
                clip.setFramePosition(0);
                if (loop) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    if (clip.isRunning()) {
                        clip.stop();
                    }
                    clip.start();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void startBackgroundMusic(String soundName) {
        playSound(backGroundClip, true);
    }

    @Override
    public void stopBackgoundMusic() {
        if (backGroundClip != null && backGroundClip.isRunning()) {
            backGroundClip.stop();
        }
    }
}
