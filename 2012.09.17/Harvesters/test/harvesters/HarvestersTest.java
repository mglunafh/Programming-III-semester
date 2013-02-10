/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harvesters;

import java.io.FileNotFoundException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class HarvestersTest {
    
    public HarvestersTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() { 
        inst = new Harvesters();
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testGetData() throws FileNotFoundException{
        inst.getData("test-Vespene-field.txt");
        
        boolean[][] temp = inst.getVespField();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (i == j && !temp[i][i]) {
                    fail("unfortunately diagonal butthurt\n");
                } 
                if (i != j && temp[i][j]) {
                    fail("unfortunately other butthurt\n");
                }
            }
        }
    }
    
    /**
     * Test of ifLarsCanDestroy method, of class Harvesters.
     */
    @Test
    public void testIfLarsCanDestroy() throws FileNotFoundException {
        int LarsPos = 0;
        int OctaviaPos = 0;
        
        inst.getData("Vespene-field.txt");
        boolean expResult = true;
        boolean result = inst.ifLarsCanDestroy("Vespene-field.txt", LarsPos, OctaviaPos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLarsCannotDestroy() throws FileNotFoundException {
        int LarsPos = 0;
        int OctaviaPos = 4;
        String fileName = "Vespene-field.txt";
        inst.getData(fileName);
        boolean result = inst.ifLarsCanDestroy(fileName, LarsPos, OctaviaPos);
        assertEquals(result, false);
                
    }
    /*
     * Test of the main method in situation when 
     */
    @Test(expected = FileNotFoundException.class)
    public void testExceptionIfLarsCanDestroy () throws FileNotFoundException {
        inst.getData("Abgzvoyathre.txt");
    }
    
    private Harvesters inst;
}
