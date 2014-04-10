/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.maps;

import golddigger.abstracts.AbsGameMap;
import golddigger.abstracts.EnMapLoaderType;

/**
 *
 * @author alexkurocha
 */
class MapFactory {
    private static MapFactory instance;
    
    private MapFactory() {
    }
    
    public static MapFactory getInstance() {
        if (instance == null) {
            instance = new MapFactory();
        }
        return instance;
    }
    
    public AbsGameMap getMapLoader(EnMapLoaderType type, GameCollection gameCollection) {
        AbsGameMap absGameMap = null;
        
        switch(type) {
            case FS: {
            absGameMap = new FsMap(gameCollection);
                break;
            }
            case DB: {
            // instantiate other game loader
                break;
            }
            default: {
            throw new IllegalArgumentException("Can't create map type: " + type);
            }
        }
        return absGameMap;
    }
    
    
}
