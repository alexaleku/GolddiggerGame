/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.maps;

import golddigger.mapobjects.Golddigger;
import golddigger.mapobjects.Treasure;
import golddigger.mapobjects.Exit;
import golddigger.mapobjects.Monster;
import golddigger.mapobjects.Nothing;
import golddigger.mapobjects.Wall;
import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.EnGameObjectType;
import golddigger.mapobjects.Coordinate;

/**
 *
 * @author alexkurocha
 */
public class MapObjectsFactory {

    private static MapObjectsFactory instance;

    public static MapObjectsFactory getInstance() {
        if (instance == null) {
            instance = new MapObjectsFactory();
        }
        return instance;

    }

    private MapObjectsFactory() {
    }

    public AbsGameObject getMapObject(EnGameObjectType gameObjectType, Coordinate coordinate) {

        AbsGameObject absGO = null;
        switch (gameObjectType) {
            case EXIT:
                absGO = new Exit(coordinate);
                break;
            case MONSTER:
                absGO = new Monster(coordinate);
                break;
            case TREASURE:
                absGO = new Treasure(coordinate);
                break;
            case WALL:
                absGO = new Wall(coordinate);
                break;
            case GOLDDIGGER:
                absGO = new Golddigger(coordinate);
                break;
            case NOTHING:
                absGO = new Nothing(coordinate);
                break;
            default:
                throw new IllegalArgumentException("Can't create object type: " + gameObjectType);
        }
        return absGO;
    }
}
