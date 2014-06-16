/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.movestrategies.impl;

import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.gameobjects.abstracts.AbsMovingObject;
import golddigger.enums.EnActionResult;
import golddigger.enums.EnMovingDirection;
import golddigger.collections.impl.GameCollection;
import golddigger.movestrategies.interfaces.IntMonsterMoveAlgorithm;
import java.util.Random;

/**
 *
 * @author alexkurocha
 */
public class MonsterMovingAggressive implements IntMonsterMoveAlgorithm {

    private final EnMovingDirection[] directions = EnMovingDirection.values();
    private AbsMovingObject movingObject;
    private GameCollection gameCollection;

    @Override
    public EnMovingDirection getDirection(AbsMovingObject movingObject, AbsGameObject targetObject, GameCollection gameCollection) {

        this.movingObject = movingObject;
        this.gameCollection = gameCollection;

        // сначала ищем вокруг, можно ли съесть игрока
        EnMovingDirection direction = searchAction(EnActionResult.DIE, false);

        // если нет рядом персонажа - просто двигаемся в случайном направлении
        if (direction == null) {
            direction = searchAction(EnActionResult.MOVE, true);
        }

        return direction;
    }

    private EnMovingDirection getRandomDirection() {
        return directions[new Random().nextInt(directions.length)];
    }

    private EnMovingDirection searchAction(EnActionResult actionResult, boolean random) {
        EnMovingDirection direction = null;

        if (random) {
            do {
                direction = getRandomDirection();
            } while (!checkActionResult(actionResult, direction));// случайно подбирать сторону пока не найдем нужный ActionResult
        } else {
            for (EnMovingDirection movingDirection : directions) {// искать по всем 4 сторонам
                if (checkActionResult(actionResult, movingDirection)) {
                    direction = movingDirection;
                    break;
                }
            }
        }

        return direction;
    }

    private boolean checkActionResult(EnActionResult actionResult, EnMovingDirection direction) {
        AbsGameObject objectInNewCoordinate = gameCollection.getObjByCoord(movingObject.getMoveTargetCoord(direction));
        return movingObject.doAction(objectInNewCoordinate).equals(actionResult);
    }
}
