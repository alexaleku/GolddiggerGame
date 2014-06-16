/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.creators;

import golddigger.gamemap.loader.impl.FsMap;
import golddigger.collections.impl.GameCollection;
import golddigger.gamemap.loader.abstracts.AbsGameMapLoader;
import golddigger.enums.EnMapLoaderType;

/**
 *
 * @author alexkurocha
 */
public class MapLoaderCreator {
    private static MapLoaderCreator instance;
    
    private MapLoaderCreator() {
    }
    
    public static MapLoaderCreator getInstance() {
        if (instance == null) {
            instance = new MapLoaderCreator();
        }
        return instance;
    }
    
    public AbsGameMapLoader getMapLoader(EnMapLoaderType type, GameCollection gameCollection) {
        AbsGameMapLoader absGameMap = null;
        
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
