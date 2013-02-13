/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtree;

import org.junit.*;
import static org.junit.Assert.*;
import searchtree.SearchTree.SearchTreeIterator;

/**
 *
 * @author Fedor Uvarychev
 */
public class SearchTreeTest {

    public SearchTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        instance = new SearchTree();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sizeOfTree method, of class SearchTree, of empty tree.
     */
    @Test
    public void testSizeOfEmptyTree() {

        int expResult = 0;
        int result = instance.sizeOfTree();
        assertEquals(expResult, result);
    }

    /**
     * Test of sizeOfTree method, of class SearchTree.
     */
    @Test
    public void testSizeOfTree() {

        instance.add(15);
        instance.add(13);
        int expResult = 2;
        int result = instance.sizeOfTree();
        assertEquals(expResult, result);
    }

    /**
     * Test of find method, of class SearchTree, applied to absent number.
     */
    @Test
    public void testFindNothing() {
        int value = 1;
        boolean expResult = false;
        boolean result = instance.find(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of find method, of class SearchTree.
     */
    @Test
    public void testFind() {
        int value = 15;
        instance.add(value);
        boolean expResult = true;
        boolean result = instance.find(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class SearchTree.
     */
    @Test
    public void testAdd() {

        int[] testValues = {1, 4, 8, 88, 1349};
        for (int i = 0; i < testValues.length; i++) {
            instance.add(testValues[i]);
        }
        for (int i = 0; i < testValues.length; i++) {
            assertEquals(true, instance.find(testValues[i]));
        }
    }

    /**
     * Test of delete method, of class SearchTree.
     */
    @Test
    public void testDelete() {
        
        int value = 88;
        int[] testValues = {1, 4, 8, 88, 1349};
        for (int i = 0; i < testValues.length; i++) {
            instance.add(testValues[i]);
        }
        instance.delete(value);
        assertEquals(false, instance.find(value));
    }

    /**
     * Test of hasNext method of class SearchTreeIterator on empty tree.
     */
    @Test
    public void testIteratorHasNotNext() {
        iter = instance.iterator();
        assertEquals(false, iter.hasNext());
    }

    /**
     * Test of hasNext method of class SearchTreeIterator.
     */
    @Test
    public void testIteratorHasNext() {
        instance.add(15);
        iter = instance.iterator();
        assertEquals(true, iter.hasNext());
    }

    /**
     * Test of next method of class SearchTreeIterator.
     */
    @Test
    public void testIteratorNext() {
        
        int[] testValues = {12, 8, 1, 4, 8, 88, 1349};
        for (int i = 0; i < testValues.length; i++) {
            instance.add(testValues[i]);
        }
        
        iter = instance.iterator();
        assertEquals(12, (iter.next()).intValue());
        assertEquals(8, (iter.next()).intValue());
        assertEquals(1, (iter.next()).intValue());
        assertEquals(4, (iter.next()).intValue());
        assertEquals(88, (iter.next()).intValue());
        assertEquals(1349, (iter.next()).intValue());
        
    }
    SearchTreeIterator iter;
    SearchTree instance;
}
