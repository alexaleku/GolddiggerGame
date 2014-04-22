/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.maps;

import golddigger.abstracts.IntMonsterMoveAlgorithm;
import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.AbsMovingObject;
import golddigger.abstracts.EnMovingDirection;
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