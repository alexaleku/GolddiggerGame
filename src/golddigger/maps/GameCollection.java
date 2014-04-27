/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.maps;

import golddigger.abstracts.IntMonsterMoveAlgorithm;
import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.AbsMovingObject;
import golddigger.abstracts.EnActionResult;
import golddigger.abstracts.EnGameObjectType;
import golddigger.abstracts.EnMovingDirection;
import golddigger.abstracts.IntMoveResultListener;
import golddigger.mapobjects.Coordinate;
import golddigger.mapobjects.Nothing;
import golddigger.mapobjects.Wall;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author alexkurocha
 */
public class GameCollection extends MoveActionNotifier {

    private final HashMap<Coordinate, AbsGameObject> gameObjects = new HashMap<>();
    private final EnumMap<EnGameObjectType, ArrayList<AbsGameObject>> byTypeGameObjects = new EnumMap<>(EnGameObjectType.class);

    public GameCollection() {
        addMoveListener(new SoundPlayerWav());
    }

    @Override
    public AbsGameObject getObjByCoord(Coordinate coordinate) {
        AbsGameObject ago = gameObjects.get(coordinate);
        if (ago == null) {
            ago = new Wall(coordinate);
        }
        return ago;
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
    public void moveObject(IntMonsterMoveAlgorithm algorithm, EnGameObjectType gameObjectType) {
        GameCollection.this.doMoveAction(null, gameObjectType, algorithm);
    }

    @Override
    public void moveObject(EnMovingDirection direction, EnGameObjectType type) {
        GameCollection.this.doMoveAction(direction, type, null);
    }

    private EnActionResult doMoveAction(EnMovingDirection direction, EnGameObjectType gameObjectType, IntMonsterMoveAlgorithm algorithm) {

        AbsMovingObject golddigger = (AbsMovingObject) getObjectsByType(EnGameObjectType.GOLDDIGGER).get(0);

        EnActionResult enActionResult = null;

        for (AbsGameObject absGameObject : getObjectsByType(gameObjectType)) {
            if (absGameObject instanceof AbsMovingObject) {
                AbsMovingObject absMovingObject = (AbsMovingObject) absGameObject;

                if (algorithm != null) {
                    direction = algorithm.getDirection(absMovingObject, golddigger, this);
                }

                // Checking what object is located in new coordinates before moving the object
                Coordinate newCoordinate = absMovingObject.getMoveTargetCoord(direction);
                AbsGameObject objectInNewCoord = getObjByCoord(newCoordinate);
//                System.out.println("gameObjectType " + gameObjectType);
//                System.out.println("direction " + direction + ";  ObjectInNewCoord " + objectInNewCoord);
                

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
            notifyListeners(enActionResult, golddigger);
            if (enActionResult == EnActionResult.DIE || enActionResult == EnActionResult.WIN) {
                break;
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

    private void swapObjects(AbsGameObject absMovingObject, AbsGameObject objectInNewCoord) {
        Coordinate tempCoordinate = absMovingObject.getCoordinate();
        absMovingObject.setCoordinate(objectInNewCoord.getCoordinate());
        objectInNewCoord.setCoordinate(tempCoordinate);

        gameObjects.put(absMovingObject.getCoordinate(), absMovingObject);
        gameObjects.put(objectInNewCoord.getCoordinate(), objectInNewCoord);
    }

    @Override
    public void notifyListeners(EnActionResult actionResult, AbsMovingObject golddiger) {
        for (IntMoveResultListener moveResultListener : getListeners()) {
            moveResultListener.moveActionPerformed(actionResult, golddiger);
        }
    }
}
