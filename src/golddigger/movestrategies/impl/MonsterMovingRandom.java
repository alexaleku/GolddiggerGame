/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.movestrategies.impl;

import golddigger.movestrategies.interfaces.IntMonsterMoveAlgorithm;
import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.gameobjects.abstracts.AbsMovingObject;
import golddigger.enums.EnMovingDirection;
import golddigger.collections.impl.GameCollection;
import java.util.Random;

/**
 *
 * @author alexkurocha
 */
public class MonsterMovingRandom implements IntMonsterMoveAlgorithm {

    @Override
    public EnMovingDirection getDirection(AbsMovingObject absMovingObject, AbsGameObject targetObject, GameCollection gc) {
        return EnMovingDirection.values()[(new Random()).nextInt(4)];
    }
    
}
