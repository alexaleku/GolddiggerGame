/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.movestrategies.impl;

import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.gameobjects.abstracts.AbsMovingObject;
import golddigger.enums.EnMovingDirection;
import golddigger.collections.impl.GameCollection;
import golddigger.movestrategies.interfaces.IntMonsterMoveAlgorithm;
import java.util.Random;

/**
 *
 * @author alexkurocha
 */
public class MonsterMovingSlow implements IntMonsterMoveAlgorithm {

    @Override
    public EnMovingDirection getDirection(AbsMovingObject movingObject, AbsGameObject targetObject, GameCollection gameCollection) {

        EnMovingDirection direction = null;

        int characterX = targetObject.getCoordinate().getX();
        int characterY = targetObject.getCoordinate().getY();

        int monsterX = movingObject.getCoordinate().getX();
        int monsterY = movingObject.getCoordinate().getY();

        int number = getRandomInt(2);// 50% шанс чтобы двинуться к игроку
        // может сгенерить 1 или 0. это и будет 50% шанса
        if (number == 1) { // 0 - двигаться по направлению к игроку
            // наугад берется любое направление к игроку
            number = getRandomInt(2);
            switch (number) {// двигаться по оси X в сторону игрока или по оси Y
                case 1: {
                    if (monsterX > characterX) {
                        direction = EnMovingDirection.LEFT;
                    } else {
                        direction = EnMovingDirection.RIGHT;
                    }
                    break;
                }
                case 2: {
                    if (monsterY > characterY) {
                        direction = EnMovingDirection.UP;
                    } else {
                        direction = EnMovingDirection.DOWN;
                    }
                    break;
                }

            }
        } else { // 1 - двигаться по направлению от игрока
            number = getRandomInt(2);
            switch (number) {// двигаться по оси X от игрока или по оси Y
                case 1: {
                    if (monsterX > characterX) {
                        direction = EnMovingDirection.RIGHT;
                    } else {
                        direction = EnMovingDirection.LEFT;
                    }
                    break;
                }
                case 2: {
                    if (monsterY > characterY) {
                        direction = EnMovingDirection.DOWN;
                    } else {
                        direction = EnMovingDirection.UP;
                    }
                    break;
                }
            }
        }

        return direction;
    }

    private int getRandomInt(int i) {
        Random r = new Random();
        return r.nextInt(i) + 1;
    }
}
