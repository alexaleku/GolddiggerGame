/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.maps;

import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.AbsMovingObject;
import golddigger.abstracts.EnActionResult;
import static golddigger.abstracts.EnActionResult.NO_ACTION;
import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.EnMovingDirection;
import golddigger.abstracts.IntGameCollection;
import golddigger.mapobjects.Coordinate;
import golddigger.mapobjects.Nothing;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public EnActionResult moveObject(EnMovingDirection direction, EnGameObjectType gameObjectType) {
        EnActionResult enActionResult = NO_ACTION;

        for (AbsGameObject absGameObject : getObjectsByType(gameObjectType)) {
            if (absGameObject instanceof AbsMovingObject) {
                AbsMovingObject absMovingObject = (AbsMovingObject) absGameObject;
                Coordinate newCoordinate = getMoveTargetCoord(absMovingObject.getCoordinate(), direction);
                AbsGameObject objectInNewCoord = getObjByCoord(newCoordinate);

                enActionResult = absMovingObject.moveToObject(direction, objectInNewCoord);

                switch (enActionResult) {
                    case MOVE:
                        swapObjects(absMovingObject, objectInNewCoord);
                        break;
                    case COLLECT_TREASURE:
                        swapObjects(absMovingObject, new Nothing(newCoordinate));
                        break;
                }

            }

        }
//            Coordinate coordinate = entry.getKey();
//            AbsGameObject absGameObject = entry.getValue();
//            
//        }
//        EnActionResult enActionResult;
//        Coordinate newCoordinate = getMoveTargetCoord(direction);
//        AbsGameObject objInNewCoord = gameMap.getGameCollection().getObjByCoord(newCoordinate);
//        if (objInNewCoord.getType() == EnGameObjectType.NOTHING) {
//            changeIcon(direction);
//            setCoordinate(newCoordinate);
//        }
//        
//        
        return enActionResult;
    }

    private Coordinate getMoveTargetCoord(Coordinate oldCoordinate, EnMovingDirection direction) {
        // берем текущие коордthis.getCoordinate().getXинаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = oldCoordinate.getX();
        int y = oldCoordinate.getY();

        Coordinate newCoordinate = new Coordinate(x, y);

        switch (direction) {   // определяем, в каком направлении нужно двигаться по массиву
            case UP: {
                newCoordinate.setXY(x, y - 1);
                break;
            }
            case DOWN: {
                newCoordinate.setXY(x, y + 1);
                break;
            }
            case LEFT: {
                newCoordinate.setXY(x - 1, y);
                break;
            }
            case RIGHT: {
                newCoordinate.setXY(x + 1, y);
                break;
            }
        }
        return newCoordinate;

    }

    private void swapObjects(AbsGameObject absMovingObject, AbsGameObject objectInNewCoord) {
        Coordinate tempCoordinate = absMovingObject.getCoordinate();
        absMovingObject.setCoordinate(objectInNewCoord.getCoordinate());
        objectInNewCoord.setCoordinate(tempCoordinate);

        gameObjects.put(absMovingObject.getCoordinate(), absMovingObject);
        gameObjects.put(objectInNewCoord.getCoordinate(), objectInNewCoord);
    }
}
