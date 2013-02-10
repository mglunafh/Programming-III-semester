/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harvesters;

import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.*;

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
        inst.getData("test-get-data.txt");
        
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
        String fileName = "test-Lars-destroys.txt";
        boolean expResult = true;
        boolean result = inst.ifLarsCanDestroy(fileName, LarsPos, OctaviaPos);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ifLarsCanDestroy method when Octavia is actually in isolation.
     */
    @Test
    public void testLarsCannotDestroy() throws FileNotFoundException {
        int LarsPos = 0;
        int OctaviaPos = 4;
        String fileName = "test-Lars-cant-destroy.txt";
        boolean result = inst.ifLarsCanDestroy(fileName, LarsPos, OctaviaPos);
        assertEquals(result, false);
                
    }
    
    @Test 
    public void testLarsCannotDestroy1() throws FileNotFoundException {
        int LarsPos = 0;
        int OctaviaPos = 1;
        String fileName = "test-Lars-cant-destroy1.txt";
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
