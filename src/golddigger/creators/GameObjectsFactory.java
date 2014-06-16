/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.creators;

import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.enums.EnGameObjectType;
import golddigger.gameobjects.impl.Coordinate;
import golddigger.gameobjects.impl.Exit;
import golddigger.gameobjects.impl.Golddigger;
import golddigger.gameobjects.impl.Monster;
import golddigger.gameobjects.impl.Nothing;
import golddigger.gameobjects.impl.Treasure;
import golddigger.gameobjects.impl.Wall;

/**
 *
 * @author alexkurocha
 */
public class GameObjectsFactory {

    private static GameObjectsFactory instance;

    public static GameObjectsFactory getInstance() {
        if (instance == null) {
            instance = new GameObjectsFactory();
        }
        return instance;

    }

    private GameObjectsFactory() {
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
