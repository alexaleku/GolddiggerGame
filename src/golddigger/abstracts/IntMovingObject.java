/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.abstracts.EnMovingDirection;

/**
 *
 * @author alexkurocha
 */
public interface IntMovingObject extends IntStaticObject {
    EnActionResult moveToObject(EnMovingDirection derection, AbsGameObject absGameObject);
    int getStep();
}
