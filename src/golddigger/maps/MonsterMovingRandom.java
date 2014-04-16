/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.maps;

import golddigger.abstracts.IntMonsterMoveAlgorithm;
import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.EnMovingDirection;
import golddigger.mapobjects.Golddigger;
import java.util.Random;

/**
 *
 * @author alexkurocha
 */
public class MonsterMovingRandom implements IntMonsterMoveAlgorithm {

    @Override
    public EnMovingDirection getDirection(AbsGameObject absGameObjectMonster, AbsGameObject absGameObjectGolddigger, GameCollection gc) {
        return EnMovingDirection.values()[(new Random()).nextInt(4)];
    }
    
}
