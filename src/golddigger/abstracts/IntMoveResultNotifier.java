package golddigger.abstracts;

import golddigger.abstracts.AbsMovingObject;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexkurocha
 */
public interface IntMoveResultNotifier {
    
    void addMoveListener(IntMoveResultListener moveResultListener);
    void removeMoveListener(IntMoveResultListener moveResultListener);
    void removeAllListeners();
    List<IntMoveResultListener> getListeners();
    void notifyListeners(EnActionResult actionResult, AbsMovingObject movingObject);
    
    
}
