/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.mapobjects.Coordinate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;

/**
 *
 * @author alexkurocha
 */
public abstract class AbsGameMap implements IntGameMap, Serializable {
    private int width;
    private int height;
    private int timeLimit;
    private String mapName;
    
    private boolean exitExist;
    private boolean characterExist;
    
    private HashMap<Coordinate, AbsGameObject> gameObjects = new HashMap<>();
    private EnumMap<EnGameObjectType, ArrayList<AbsGameObject>> byTypeGameObjects = new EnumMap<>(EnGameObjectType.class);
    
    public AbsGameObject getPriorityObject(AbsGameObject obj1, AbsGameObject obj2) {
        return  (obj1.getType().getPriority() > obj2.getType().getPriority()) ? obj1 : obj2;
        
    }
    
    public boolean isMapValid() {
        return exitExist && characterExist;
    }

    
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public boolean saveMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTimeLimit() {
        return timeLimit;
    }
    
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public AbsGameObject getObjByCoord(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }
    
    public AbsGameObject getObjByCoord(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    public Collection<AbsGameObject> getGameObjects() {
        return gameObjects.values();
    }
    
    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public boolean isExitExist() {
        return exitExist;
    }

    public void setExitExist(boolean exitExist) {
        this.exitExist = exitExist;
    }

    public boolean isCharacterExist() {
        return characterExist;
    }

    public void setCharacterExist(boolean characterExist) {
        this.characterExist = characterExist;
    }
    public ArrayList<AbsGameObject> getObjectsByType(EnGameObjectType type) {
        return byTypeGameObjects.get(type);
    }
    
    public void addObjectsToCollections(AbsGameObject absGameObject) {
        gameObjects.put(absGameObject.getCoordinate(), absGameObject);
        if(byTypeGameObjects.get(absGameObject.getType()) == null) {
            ArrayList<AbsGameObject> arrayList = new ArrayList<AbsGameObject>();
            byTypeGameObjects.put(absGameObject.getType(), arrayList);
        }
            byTypeGameObjects.get(absGameObject.getType()).add(absGameObject);
        
    }
    
}
