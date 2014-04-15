/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.maps;

import golddigger.abstracts.IntGameCollection;
import golddigger.abstracts.IntMoveResultListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexkurocha
 */
public abstract class MoveActionNotifier implements IntGameCollection {
    private final List<IntMoveResultListener> moveResultListeners = new ArrayList<>();

    @Override
    public void addMoveListener(IntMoveResultListener moveResultListener) {
        moveResultListeners.add(moveResultListener);
    }

    @Override
    public void removeMoveListener(IntMoveResultListener moveResultListener) {
        moveResultListeners.remove(moveResultListener);
    }

    @Override
    public void removeAllListeners() {
        moveResultListeners.clear();
    }

    @Override
    public List<IntMoveResultListener> getListeners() {
        return moveResultListeners;
    }
}
