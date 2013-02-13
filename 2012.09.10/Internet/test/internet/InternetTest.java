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
        inst = new Internet("internet-matrix.txt", "internet-info.txt");
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
        inst.show();
        
    }
    
    private Internet inst;
}
