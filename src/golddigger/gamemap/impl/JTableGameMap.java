/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golddigger.gamemap.impl;

import golddigger.gamemap.interfaces.IntTimeMap;
import golddigger.collections.impl.GameCollection;
import golddigger.movestrategies.impl.MonsterMovingSlow;
import golddigger.gamemap.loader.abstracts.AbsGameMapLoader;
import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.enums.EnGameObjectType;
import golddigger.enums.EnMapLoaderType;
import golddigger.gameobjects.impl.Coordinate;
import golddigger.gameobjects.impl.Nothing;
import golddigger.creators.MapLoaderCreator;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author alexkurocha
 */
public class JTableGameMap implements IntTimeMap {

    private JTable jTableMap = new JTable();
    private AbsGameMapLoader gameMap;
    private AbsGameObject[][] mapObjects;
    private String[] columnNames;

    public JTableGameMap(EnMapLoaderType mapLoaderType, String mapLocationSource, GameCollection gameCollection) {
        jTableMap.setEnabled(false);
        jTableMap.setSize(new java.awt.Dimension(300, 312));
        jTableMap.setRowHeight(26);
        jTableMap.setRowSelectionAllowed(false);
        jTableMap.setShowHorizontalLines(false);
        jTableMap.setShowVerticalLines(false);
        jTableMap.setTableHeader(null);
        jTableMap.setUpdateSelectionOnSort(false);
        jTableMap.setVerifyInputWhenFocusTarget(false);

        gameMap = MapLoaderCreator.getInstance().getMapLoader(mapLoaderType, gameCollection);
        gameMap.loadMap(mapLocationSource);
        
    }

    public boolean drawMap() {
        updateObjectsArray();

        try {
            // присваиваем пустоту всем заголовкам столбцов, чтобы у таблицы не было заголовоков, а то некрасиво смотрится
            columnNames = new String[gameMap.getWidth()];

            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = "";
            }

            // игровое поле будет отображаться в super без заголовков столбцов
            jTableMap.setModel(new DefaultTableModel(mapObjects, columnNames));

            // вместо текста в ячейках таблицы устанавливаем отображение картинки
            for (int i = 0; i < jTableMap.getColumnCount(); i++) {
                jTableMap.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
                TableColumn a = jTableMap.getColumnModel().getColumn(i);
                a.setPreferredWidth(26);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Component getMap() {
        return jTableMap;
    }

    private void updateObjectsArray() {
        mapObjects = new AbsGameObject[gameMap.getHeight()][gameMap.getWidth()];
        fillMapWithNothingObjects(gameMap.getHeight(), gameMap.getWidth());
        for (AbsGameObject absGameObject : gameMap.getGameCollection().getGameObjects()) {

            if (absGameObject.getType() != EnGameObjectType.NOTHING) {
                int y = absGameObject.getCoordinate().getY();
                int x = absGameObject.getCoordinate().getX();
                if (mapObjects[y][x].getType() != EnGameObjectType.NOTHING || // если в этих координатах уже есть какой то объект, отличный от пустоты и стены
                        mapObjects[y][x].getType() != EnGameObjectType.WALL) {
                    AbsGameObject tmpObj = mapObjects[y][x];
                    mapObjects[y][x] = gameMap.getGameCollection().getPriorityObject(tmpObj, absGameObject);
                } else {
                    mapObjects[y][x] = absGameObject;// проставить объект на карте согласно его координатам
                }
            }

        }
    }

    private void fillMapWithNothingObjects(int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                mapObjects[i][j] = new Nothing(new Coordinate(i, j));
            }
        }
    }

    public AbsGameMapLoader getGameMap() {
        return gameMap;
    }

    private MoveMonsterTimer moveTimer = new MoveMonsterTimer();

    @Override
    public void stop() {
        moveTimer.stopTimer();
    }

    @Override
    public void start() {
        moveTimer.startTimer();
    }
    
    public class MoveMonsterTimer implements ActionListener {
        
        private Timer timer;
        private final static int MOVE_DELAY = 500;
        private final static int INITIAL_DELAY = 500;
        
        public MoveMonsterTimer() {
        timer = new Timer(MOVE_DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
        }
        

        public void startTimer() {
            timer.start();
        }

        public void stopTimer() {
            timer.stop();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getGameMap().getGameCollection().moveObject(new MonsterMovingSlow(), EnGameObjectType.MONSTER);
        }
    }

}
