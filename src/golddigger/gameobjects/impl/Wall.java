/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.gameobjects.impl;

import golddigger.enums.EnGameObjectType;
import golddigger.gameobjects.abstracts.AbsGameObject;

/**
 *
 * @author alexkurocha
 */
public class Wall extends AbsGameObject {
    private String imagePath = "/golddigger/images/wall.png";

    public Wall(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(EnGameObjectType.WALL);
        super.setImageIcon(getImageIcon(imagePath));
    }
    
    
}
