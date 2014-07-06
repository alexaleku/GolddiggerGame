/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.gameobjects.interfaces;

import golddigger.enums.EnActionResult;
import javax.sound.sampled.Clip;

/**
 *
 * @author alexkurocha
 */
public interface IntSoundObject {
    Clip getSoundClip(EnActionResult actionResult);
}
