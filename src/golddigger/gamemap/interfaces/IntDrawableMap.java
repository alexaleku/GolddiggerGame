/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.gamemap.interfaces;

import golddigger.gamemap.loader.abstracts.AbsGameMapLoader;
import java.awt.Component;

/**
 *
 * @author alexkurocha
 */
public interface IntDrawableMap {
    boolean drawMap();
    Component getMap();

    public AbsGameMapLoader getGameMap();
    
}
