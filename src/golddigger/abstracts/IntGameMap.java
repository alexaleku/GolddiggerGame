/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.abstracts;

/**
 *
 * @author alexkurocha
 */
public interface IntGameMap {
    int getHeight();
    int getWidth();
    int getTimeLimit();
    boolean loadMap(Object source);
    boolean saveMap();
}
