/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.abstracts.EnGameObjectType;
import golddigger.mapobjects.Coordinate;
import javax.swing.ImageIcon;

/**
 *
 * @author alexkurocha
 */
public interface IntStaticObject {
    ImageIcon getIcon();
    Coordinate getCoordinate();
    EnGameObjectType getType();   
}
