/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.mapobjects.Coordinate;
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
    
    EnActionResult moveObject(EnMovingDirection direction, EnGameObjectType gameObjectType, IntMonsterMoveAlgorithm algorithm);
    
}
