/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.movestrategies.impl;

import golddigger.collections.impl.GameCollection;
import golddigger.enums.EnMovingDirection;
import golddigger.gameobjects.abstracts.AbsGameObject;
import golddigger.gameobjects.abstracts.AbsMovingObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexkurocha
 */
public class MonsterMovingAggressiveTest {
    
    public MonsterMovingAggressiveTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDirection method, of class MonsterMovingAggressive.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        AbsMovingObject movingObject = null;
        AbsGameObject targetObject = null;
        GameCollection gameCollection = null;
        MonsterMovingAggressive instance = new MonsterMovingAggressive();
        EnMovingDirection expResult = null;
        EnMovingDirection result = instance.getDirection(movingObject, targetObject, gameCollection);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
