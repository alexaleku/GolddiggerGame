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
import golddigger.abstracts.IntSoundPlayer;
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

    private Clip backGroundClip;
    private Clip moveClip;

    public SoundPlayerWav() {
        try {
            backGroundClip = AudioSystem.getClip();
            moveClip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void moveActionPerformed(EnActionResult actionResult, AbsMovingObject movingObject) {
        if (actionResult.equals(EnActionResult.DIE)) {
            System.out.println("here -----------");
            backGroundClip.stop();
        backGroundClip.close();
            stopBackgoundMusic();
        }
        if (!(movingObject instanceof IntSoundObject)) {
            return;
        }
        IntSoundObject so = (IntSoundObject) movingObject;
        playSound(so.getSoundPath(actionResult), false, true, moveClip);

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
    @Override
    public void playSound(String soundFilePath, final boolean isLoopping, final boolean isStopPrevious) {
        try {
            playSound(soundFilePath, isLoopping, isStopPrevious, AudioSystem.getClip());
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playSound(String soundFilePath, final boolean isLoopping, final boolean isStopPrevious, final Clip clip) {
        try {

            if (soundFilePath == null) {
                return;
            }
            URL resource = this.getClass().getResource("/golddigger/sounds/" + soundFilePath);
            final AudioInputStream ais = AudioSystem.getAudioInputStream(resource);

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    try {
                        if (isStopPrevious && clip != null) {
                            clip.stop();
                            clip.close();
                        }

                        clip.open(ais);

                        if (isLoopping) {
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        } else {
                            clip.start();
                        }
                    } catch (LineUnavailableException | IOException ex) {
                        Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundPlayerWav.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void startBackgroundMusic(String soundName) {
        playSound(soundName, true, false, backGroundClip);
    }

    @Override
    public void stopBackgoundMusic() {
        backGroundClip.stop();
        backGroundClip.close();
    }

}
