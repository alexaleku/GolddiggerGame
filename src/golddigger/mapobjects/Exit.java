/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.mapobjects;

import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.AbsGameObject;

/**
 *
 * @author alexkurocha
 */
public class Exit extends AbsGameObject {
    private final String imagePath = "/golddigger/images/exit.png";

    public Exit(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(EnGameObjectType.EXIT);
        super.setImageIcon(getImageIcon(imagePath));
    }
    
}
