/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.EnMovingDirection;
import golddigger.mapobjects.Golddigger;
import golddigger.maps.GameCollection;

/**
 *
 * @author alexkurocha
 */
public interface IntMonsterMoveAlgorithm {
    EnMovingDirection getDirection(AbsGameObject absGameObjectMonster, AbsGameObject absGameObjectGolddigger, GameCollection gc);
}
