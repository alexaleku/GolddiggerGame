/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import java.awt.Component;

/**
 *
 * @author alexkurocha
 */
public interface IntDrawableMap {
    boolean drawMap();
    Component getMap();

    public AbsGameMap getGameMap();
    
}
