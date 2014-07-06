/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.sound.interfaces;

import golddigger.enums.EnActionResult;

/**
 *
 * @author alexkurocha
 */
public interface IntSoundObject {
    String getSoundPath(EnActionResult actionResult);
}
