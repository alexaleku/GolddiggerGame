/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.gameobjects.interfaces;

import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.enums.EnActionResult;
import golddigger.enums.EnMovingDirection;

/**
 *
 * @author alexkurocha
 */
public interface IntMovingObject extends IntStaticObject {
    EnActionResult moveToObject(EnMovingDirection derection, AbsGameObject absGameObject);
    int getStep();
}
