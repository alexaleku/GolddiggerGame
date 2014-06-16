/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.movestrategies.interfaces;

import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.gameobjects.abstracts.AbsMovingObject;
import golddigger.enums.EnMovingDirection;
import golddigger.collections.impl.GameCollection;

/**
 *
 * @author alexkurocha
 */
public interface IntMonsterMoveAlgorithm {
    EnMovingDirection getDirection(AbsMovingObject absMovingObject, AbsGameObject targetObject, GameCollection gc);
}
