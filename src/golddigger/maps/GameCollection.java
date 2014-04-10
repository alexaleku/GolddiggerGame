/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.maps;

import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.EnMovingDirection;
import golddigger.abstracts.IntGameCollection;
import golddigger.mapobjects.Coordinate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author alexkurocha
 */
public class GameCollection implements IntGameCollection {

    private final HashMap<Coordinate, AbsGameObject> gameObjects = new HashMap<>();
    private final EnumMap<EnGameObjectType, ArrayList<AbsGameObject>> byTypeGameObjects = new EnumMap<>(EnGameObjectType.class);

    @Override
    public AbsGameObject getObjByCoord(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    public AbsGameObject getPriorityObject(AbsGameObject obj1, AbsGameObject obj2) {
        return (obj1.getType().getPriority() > obj2.getType().getPriority()) ? obj1 : obj2;

    }

    @Override
    public AbsGameObject getObjByCoord(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    @Override
    public List<AbsGameObject> getGameObjects() {
        return new ArrayList(gameObjects.values());
    }

    @Override
    public ArrayList<AbsGameObject> getObjectsByType(EnGameObjectType type) {
        return byTypeGameObjects.get(type);
    }

    @Override
    public void addObjectsToCollections(AbsGameObject absGameObject) {
        gameObjects.put(absGameObject.getCoordinate(), absGameObject);
        if (byTypeGameObjects.get(absGameObject.getType()) == null) {
            ArrayList<AbsGameObject> arrayList = new ArrayList<>();
            byTypeGameObjects.put(absGameObject.getType(), arrayList);
        }
        byTypeGameObjects.get(absGameObject.getType()).add(absGameObject);

    }

    @Override
    public void moveObject(EnMovingDirection direction, EnGameObjectType gameObjectType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
