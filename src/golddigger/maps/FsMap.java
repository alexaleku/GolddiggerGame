/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.maps;

import golddigger.abstracts.AbsGameMap;
import golddigger.abstracts.AbsGameObject;
import golddigger.abstracts.EnGameObjectType;
import golddigger.mapobjects.Coordinate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexkurocha
 */
public class FsMap extends AbsGameMap {

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
            setHeight(Integer.valueOf(mapInfo[2]));

            int x = 0;
            int y = 0;

            while ((line = br.readLine()) != null) {
                x = 0;
                for (String item : line.trim().split(csvSplitBy)) {
                    createMapObject(x, y, item);
                    y++;

                }
                x++;
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
        AbsGameObject absGameObject = MapObjectsFactory.getInstance().getMapObject(gameObjectType, new Coordinate(i, j));
        addObjectsToCollections(absGameObject);

        if (absGameObject.getType() == EnGameObjectType.EXIT) {
            setExitExist(true);
        }
        if (absGameObject.getType() == EnGameObjectType.GOLDDIGGER) {
            setCharacterExist(true);
        }

    }
}
