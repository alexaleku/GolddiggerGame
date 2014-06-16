/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.collections.interfaces;

import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.enums.EnGameObjectType;
import golddigger.enums.EnMovingDirection;
import golddigger.listeners.interfaces.IntMoveResultNotifier;
import golddigger.movestrategies.interfaces.IntMonsterMoveAlgorithm;
import golddigger.gameobjects.impl.Coordinate;
import java.util.List;

/**
 *
 * @author alexkurocha
 */
public interface IntGameCollection extends IntMoveResultNotifier {

    AbsGameObject getObjByCoord(Coordinate coordinate);

    AbsGameObject getObjByCoord(int x, int y);

    List<AbsGameObject> getGameObjects();

    List<AbsGameObject> getObjectsByType(EnGameObjectType type);

    void addObjectsToCollections(AbsGameObject absGameObject);

    void moveObject(IntMonsterMoveAlgorithm algorithm, EnGameObjectType gameObjectType);

    void moveObject(EnMovingDirection direction, EnGameObjectType type);

}
