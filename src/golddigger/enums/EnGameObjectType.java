/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.enums;

/**
 *
 * @author alexkurocha
 */
public enum EnGameObjectType {
    MONSTER(5),
    TREASURE(4),
    EXIT(3),
    WALL(2),
    GOLDDIGGER(1),
    NOTHING(-1);
    
    private int priority;
    
    private EnGameObjectType(int priority) {
    this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}