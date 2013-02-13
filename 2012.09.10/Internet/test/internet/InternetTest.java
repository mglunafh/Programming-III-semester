/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internet;

import java.io.FileNotFoundException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class InternetTest {
    
    class TestRandomizer implements Randomizer
    {
        @Override
        public int nextInt(int bound) {
            return this.rndArray[index++];
        }
        
        private int[] rndArray = {13, 4, 0, 13, 20};
        private int index;
    };
    
    
    public InternetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        Randomizer rand = new TestRandomizer();
        inst = new Internet("internet-matrix.txt", "internet-info.txt", rand);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of nextStep method, of class Internet.
     */
    @Test
    public void testShow() throws FileNotFoundException {
        System.out.println("show");
        inst.update();
        for (int i = 0; i < 3; i++) {
            assertEquals(true, inst.getComps().get(i).getState()) ;
            assertEquals(false, inst.getComps().get(i + 3).getState());
        }
        
        inst.update();
        for (int i = 0; i < 4; i++) {
            assertEquals(true, inst.getComps().get(i).getState());
        }
        assertEquals(false, inst.getComps().get(4).getState());
        assertEquals(false, inst.getComps().get(5).getState());
        
        inst.update();
        for (int i = 0; i < 5; i++) {
            assertEquals(true, inst.getComps().get(i).getState());
        }
        assertEquals(false, inst.getComps().get(5).getState());
    }
    
    private Internet inst;
}
