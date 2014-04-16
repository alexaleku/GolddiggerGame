/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

import golddigger.maps.GameCollection;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private GameCollection gameCollection;

    public AbsGameMap(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

   public GameCollection getGameCollection() {
        if (gameCollection == null) {
            try {
                throw new Exception("Game collection not initialized!");
            } catch (Exception ex) {
                Logger.getLogger(AbsGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gameCollection;
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

    public EnActionResult move(EnMovingDirection enMovingDirection, EnGameObjectType enGameObjectType) {
        return getGameCollection().moveObject(enMovingDirection, enGameObjectType, null);
    }
}
