/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.gamemap.loader.impl;

import golddigger.collections.impl.GameCollection;
import golddigger.gamemap.loader.abstracts.AbsGameMapLoader;
import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.enums.EnGameObjectType;
import golddigger.gameobjects.impl.Coordinate;
import golddigger.creators.GameObjectsFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexkurocha
 */
public class FsMap extends AbsGameMapLoader {

    public FsMap(GameCollection gameCollection) {
        super(gameCollection);
    }

    @Override
    public boolean loadMap(Object source) {

        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        File file = new File((String) source);
        if (!file.exists()) {
            throw new IllegalArgumentException("file doesn't exist");
        }

        try {
            setExitExist(false);
            setCharacterExist(false);
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            String[] mapInfo = new String[line.trim().split(csvSplitBy).length];
            mapInfo = line.trim().split(csvSplitBy);

            setMapName(mapInfo[0]);
            setTimeLimit(Integer.valueOf(mapInfo[1]));

            setWidth(Integer.valueOf(mapInfo[2]));
            setHeight(Integer.valueOf(mapInfo[3]));

            int x = 0;

            for (int y = 0; y<getHeight(); y++) {
                line = br.readLine();
                if(line != null) {
                x = 0;
                for (String item : line.trim().split(csvSplitBy)) {
                    createMapObject(x, y, item);
                    x++;

                }
                }
            }
            
            if (!isMapValid()) {
                throw new Exception("Map is not valid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Done");
        return true;
    }

    private void createMapObject(int i, int j, String objectCode) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "x = " + i + "y = " + j + "name = " + objectCode);
        EnGameObjectType gameObjectType = EnGameObjectType.valueOf(objectCode.toUpperCase());
        AbsGameObject absGameObject = GameObjectsFactory.getInstance().getMapObject(gameObjectType, new Coordinate(i, j));
        getGameCollection().addObjectsToCollections(absGameObject);

        if (absGameObject.getType() == EnGameObjectType.EXIT) {
            setExitExist(true);
        }
        if (absGameObject.getType() == EnGameObjectType.GOLDDIGGER) {
            setCharacterExist(true);
        }

    }
}
