package adt.btree;

import org.junit.Before;

import org.junit.Test;
import adt.btree.BNode;
import adt.btree.BTree;
import adt.btree.BTreeImpl;

import static org.junit.Assert.*;

public class BTreeImplTest {

    BTree<Integer> myBTree;

    @Before
    public void initialize() {
        myBTree = new BTreeImpl<Integer>(6);
    }

    @Test
    public void testGetRoot0() {
        BNode<Integer> ROOT = new BNode<Integer>(6);
        assertEquals(ROOT, myBTree.getRoot());
    }

    @Test
    public void testGetRoot1() {
        BNode<Integer> ROOT = new BNode<Integer>(6);
        ROOT.addElement(10);
        myBTree.insert(10);
        assertEquals(ROOT, myBTree.getRoot());
    }

    @Test
    public void testIsEmpty0() {
        assertTrue(myBTree.isEmpty());
    }

    @Test
    public void testIsEmpty1() {
        myBTree.insert(20);
        assertFalse(myBTree.isEmpty());
    }

    @Test
    public void testHeight0() {
        assertEquals(-1, myBTree.height());
    }

    @Test
    public void testHeight1() {
        myBTree.insert(20);
        assertEquals(0, myBTree.height());
    }

    @Test
    public void testHeight2() {
        myBTree.insert(0);
        myBTree.insert(5);
        myBTree.insert(10);
        myBTree.insert(15);
        myBTree.insert(20);
        assertEquals(0, myBTree.height());
    }

    @Test
    public void testHeight3() {
        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(5);
        myBTree.insert(6);

        assertEquals(1, myBTree.height());
    }

    /*
     * @Test public void testHeight4() { myBTree.insert(5); myBTree.insert(10);
     * myBTree.insert(15); myBTree.insert(20); myBTree.insert(25);
     * myBTree.insert(1); myBTree.insert(2); myBTree.insert(3);
     * myBTree.insert(4); myBTree.insert(0); myBTree.insert(1);
     * myBTree.insert(2); myBTree.insert(1); myBTree.insert(6);
     * myBTree.insert(7); myBTree.insert(8); myBTree.insert(0);
     * myBTree.insert(0); myBTree.insert(0); myBTree.insert(0);
     * myBTree.insert(0);
     * 
     * assertEquals(2, myBTree.height()); }
     */

    @Test
    public void testSize0() {
        assertEquals(0, myBTree.size());
    }

    @Test
    public void testSize1() {
        myBTree.insert(1);
        assertEquals(1, myBTree.size());
    }

    /*
     * @Test public void testSize2() { myBTree.insert(1); myBTree.insert(2);
     * myBTree.insert(3); myBTree.insert(4); myBTree.insert(5);
     * myBTree.insert(6); myBTree.insert(7); myBTree.insert(8);
     * myBTree.insert(9); myBTree.insert(10); myBTree.insert(11);
     * myBTree.insert(12); myBTree.insert(13); myBTree.insert(14);
     * myBTree.insert(15); myBTree.insert(16); myBTree.insert(17);
     * myBTree.insert(18); myBTree.insert(19); myBTree.insert(20);
     * myBTree.insert(21); myBTree.insert(22); myBTree.insert(23);
     * myBTree.insert(24); myBTree.insert(25); myBTree.insert(26);
     * myBTree.insert(27); myBTree.insert(28); myBTree.insert(29);
     * myBTree.insert(30); myBTree.insert(31); myBTree.insert(32);
     * myBTree.insert(33); myBTree.insert(34); myBTree.insert(35);
     * myBTree.insert(36); assertEquals(36, myBTree.size()); }
     */

    /*
     * @Test public void testSearch0() { myBTree.insert(1);
     * 
     * assertNull(myBTree.search(2).node);
     * 
     * assertEquals(1, myBTree.search(2).position); }
     */

    @Test
    public void testSearch1() {
        myBTree.insert(1);
        assertEquals(new Integer(1), myBTree.search(1).node.getElementAt(0));
        assertEquals(0, myBTree.search(1).position);
    }

    @Test
    public void testSearch2() {
        myBTree.insert(2);
        myBTree.insert(1);
        assertEquals(new Integer(2), myBTree.search(2).node.getElementAt(1));
        assertEquals(1, myBTree.search(2).position);
    }

    /*
     * @Test public void testSearch3() { myBTree.insert(1); myBTree.insert(2);
     * myBTree.insert(3); myBTree.insert(4); myBTree.insert(5);
     * myBTree.insert(6);
     * 
     * assertEquals(myBTree.getRoot(), myBTree.search(3).node); assertEquals(0,
     * myBTree.search(3).position); }
     */

    public Integer[] makeIntegerArray(int[] array) {
        Integer[] no = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
            no[i] = new Integer(array[0]);
        return no;
    }

    @Test
    public void testInsert0() {
        int[] res1 = { 1, 2, 3, 4, 5 };
        Integer[] no1 = makeIntegerArray(res1);

        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(5);
        
        Integer[] s = myBTree.depthLeftOrder()[0].getElements().toArray(no1);

        assertArrayEquals(no1,s);
//                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
    }

    @Test
    public void testInsert1() {
        int[] res1 = { 4 };
        Integer[] no1 = makeIntegerArray(res1);

        int[] res2 = { 1, 2, 3 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 5, 6 };
        Integer[] no3 = makeIntegerArray(res3);

        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(5);
        myBTree.insert(6);

        assertArrayEquals(no1,
                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[1].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[2].getElements().toArray(no3));
    }

    @Test
    public void testInsert2() {
        int[] res1 = { 3 };
        Integer[] no1 = makeIntegerArray(res1);

        int[] res2 = { 1, 1, 2 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 4, 5 };
        Integer[] no3 = makeIntegerArray(res3);

        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(5);
        myBTree.insert(1);

        assertArrayEquals(no1,
                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[1].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[2].getElements().toArray(no3));
    }

    @Test
    public void testInsert3() {
        int[] res1 = { 3 };
        Integer[] no1 = makeIntegerArray(res1);

        int[] res2 = { 1, 1, 2 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 4, 6, 7 };
        Integer[] no3 = makeIntegerArray(res3);

        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(7);
        myBTree.insert(1);
        myBTree.insert(6);

        assertArrayEquals(no1,
                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[1].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[2].getElements().toArray(no3));
    }

    @Test
    public void testInsert4() {
        int[] res1 = { 4, 15 };
        Integer[] no1 = makeIntegerArray(res1);

        int[] res2 = { 1, 2, 3 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 5, 10 };
        Integer[] no3 = makeIntegerArray(res3);

        int[] res4 = { 20, 25 };
        Integer[] no4 = makeIntegerArray(res4);

        myBTree.insert(5);
        myBTree.insert(10);
        myBTree.insert(15);
        myBTree.insert(20);// 1,2,5,10,15,20,25
        myBTree.insert(25);
        myBTree.insert(1); // inseri 1 inseri 2 inseri 3 inseri 4
        myBTree.insert(2); // 1,5,10/15*,20,25 - 15 - 1,2,5,10/20,25 - 15 -
                           // 1,2,3,5,10/20,25 -15- 1,2,3/4*,5,10/20,25 - 4,15
                           // - 1,2,3|5,10|20,25
        myBTree.insert(3);
        myBTree.insert(4);

        assertArrayEquals(no1,
                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[1].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[2].getElements().toArray(no3));
        assertArrayEquals(no4,
                myBTree.depthLeftOrder()[3].getElements().toArray(no4));
    }

    @Test
    public void testInsert5() {
        int[] res1 = { 2, 4, 15 };
        Integer[] no1 = makeIntegerArray(res1);
        // 0,1,1/2,3/5,10/20,25/2,4,15
        int[] res2 = { 0, 1, 1, 1 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 2, 3 };
        Integer[] no3 = makeIntegerArray(res3);

        int[] res4 = { 5, 10 };
        Integer[] no4 = makeIntegerArray(res4);

        int[] res5 = { 20, 25 };
        Integer[] no5 = makeIntegerArray(res5);

        myBTree.insert(5);
        myBTree.insert(10);
        myBTree.insert(15);
        myBTree.insert(20);
        myBTree.insert(25);
        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(0);
        myBTree.insert(1);// 1,5,10,15*,20,25 - 1,5,10/20,25/15 -
                          // 1,2,5,10/20,25/15 - 1,2,3,5,10/20,25/15
        myBTree.insert(2);// 1,2,3,4*,5,10/20,25/15 - 1,2,3/5,10/20,25/4,15 -
                          // 0,1,2,3/5,10/20,25/4,15
        myBTree.insert(1);// 0,1,1,2,3/5,10/20,25/4,15 -
                          // 0,1,1,2*,2,3/5,10/20,25/4,15 -
                          // 0,1,1,1/2,3/5,10/20,25/2,4,15

        assertArrayEquals(no1,
                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[1].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[2].getElements().toArray(no3));
        assertArrayEquals(no4,
                myBTree.depthLeftOrder()[3].getElements().toArray(no4));
        assertArrayEquals(no5,
                myBTree.depthLeftOrder()[4].getElements().toArray(no5));
    }

    @Test
    public void testInsert6() {
        int[] res1 = { /* 1, 3, 6, 15 */2, 4, 15 };
        Integer[] no1 = makeIntegerArray(res1);

        int[] res2 = { /* 0, 1, 1 */0, 1, 1, 1 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 2, 3 };
        Integer[] no3 = makeIntegerArray(res3);

        int[] res4 = { /* 4, 5 */5, 6, 7, 8, 10 };
        Integer[] no4 = makeIntegerArray(res4);

        /*
         * int[] res5 = { 7, 8, 10 }; Integer[] no5 = makeIntegerArray(res5);
         */

        int[] res6 = { 20, 25 };
        Integer[] no6 = makeIntegerArray(res6);

        myBTree.insert(5); // 1,5,10,15,20,25 - 1,5,10,15*,20,25 -
                           // 1,5,10/20,25/15
        myBTree.insert(10);// 1,2,3,4*,5,10/20,25/15 -
                           // 0,1,1,2*,2,3/5,10/20,25/4,15
        myBTree.insert(15);// 0,1,1,1/2,3/5,6,7,8,10/20,25/2,4,15
        myBTree.insert(20);
        myBTree.insert(25);
        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(0);
        myBTree.insert(1);// 1,5,10/20,25/15 -
                          // 0,1,1,1/2,3/5,6,7,8,10/20,25/2,4,15
        myBTree.insert(2);
        ;
        myBTree.insert(1);
        myBTree.insert(6);
        myBTree.insert(7);
        myBTree.insert(8);

        assertArrayEquals(no1,
                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[1].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[2].getElements().toArray(no3));
        assertArrayEquals(no4,
                myBTree.depthLeftOrder()[3].getElements().toArray(no4));
        // assertArrayEquals(no5,
        // myBTree.depthLeftOrder()[4].getElements().toArray(no5));
        assertArrayEquals(no6,
                myBTree.depthLeftOrder()[4].getElements().toArray(no6));
    }

    @Test
    public void testInsert7() {
        int[] res1 = { /* 1, 3, 6, 15, 30 */2, 4, 15, 35 };
        Integer[] no1 = makeIntegerArray(res1);

        int[] res2 = { 0, 1, 1, 1 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 2, 3 };
        Integer[] no3 = makeIntegerArray(res3);

        int[] res4 = { /* 4, 5 */5, 6, 7, 8, 10 };
        Integer[] no4 = makeIntegerArray(res4);

        int[] res5 = { /* 7, 8, 10 */20, 25, 30 };
        Integer[] no5 = makeIntegerArray(res5);

        int[] res6 = { /* 20, 25 */40, 45 };
        Integer[] no6 = makeIntegerArray(res6);

        /*
         * int[] res7 = { 35, 40, 45 }; Integer[] no7 = makeIntegerArray(res7);
         */

        myBTree.insert(5);
        myBTree.insert(10);
        myBTree.insert(15);
        myBTree.insert(20);
        myBTree.insert(25);
        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(0);
        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(1);
        myBTree.insert(6);
        myBTree.insert(7);
        myBTree.insert(8);
        myBTree.insert(30);
        myBTree.insert(35);
        myBTree.insert(40);
        myBTree.insert(45);

        assertArrayEquals(no1,
                myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[1].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[2].getElements().toArray(no3));
        assertArrayEquals(no4,
                myBTree.depthLeftOrder()[3].getElements().toArray(no4));
        assertArrayEquals(no5,
                myBTree.depthLeftOrder()[4].getElements().toArray(no5));
        assertArrayEquals(no6,
                myBTree.depthLeftOrder()[5].getElements().toArray(no6));
        // assertArrayEquals(no7,
        // myBTree.depthLeftOrder()[6].getElements().toArray(no7));
    }

    @Test
    public void testInsert8() {
        /*
         * int[] res1 = { 6 }; Integer[] no1 = makeIntegerArray(res1);
         */

        int[] res2 = { 2, 4, 15, 35 };
        Integer[] no2 = makeIntegerArray(res2);

        int[] res3 = { 0, 1, 1, 1 };
        Integer[] no3 = makeIntegerArray(res3);

        int[] res4 = { 2, 3 };
        Integer[] no4 = makeIntegerArray(res4);

        int[] res5 = { 5, 6, 7, 8, 10 };
        Integer[] no5 = makeIntegerArray(res5);

        int[] res6 = { 20, 25, 30 };
        Integer[] no6 = makeIntegerArray(res6);

        int[] res7 = { 40, 45, 50, 55, 60 };
        Integer[] no7 = makeIntegerArray(res7);

        /*
         * int[] res8 = { 20, 25 }; Integer[] no8 = makeIntegerArray(res8);
         * 
         * int[] res9 = { 35, 40 }; Integer[] no9 = makeIntegerArray(res9);
         * 
         * int[] res10 = { 50, 55, 60 }; Integer[] no10 =
         * makeIntegerArray(res10);
         */

        myBTree.insert(5);
        myBTree.insert(10);
        myBTree.insert(15);
        myBTree.insert(20);
        myBTree.insert(25);
        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(3);
        myBTree.insert(4);
        myBTree.insert(0);
        myBTree.insert(1);
        myBTree.insert(2);
        myBTree.insert(1);
        myBTree.insert(6);
        myBTree.insert(7);
        myBTree.insert(8);
        myBTree.insert(30);
        myBTree.insert(35);
        myBTree.insert(40);
        myBTree.insert(45);
        myBTree.insert(50);
        myBTree.insert(55);
        myBTree.insert(60);

        // assertArrayEquals(no1,
        // myBTree.depthLeftOrder()[0].getElements().toArray(no1));
        assertArrayEquals(no2,
                myBTree.depthLeftOrder()[0].getElements().toArray(no2));
        assertArrayEquals(no3,
                myBTree.depthLeftOrder()[1].getElements().toArray(no3));
        assertArrayEquals(no4,
                myBTree.depthLeftOrder()[2].getElements().toArray(no4));
        assertArrayEquals(no5,
                myBTree.depthLeftOrder()[3].getElements().toArray(no5));
        assertArrayEquals(no6,
                myBTree.depthLeftOrder()[4].getElements().toArray(no6));
        assertArrayEquals(no7,
                myBTree.depthLeftOrder()[5].getElements().toArray(no7));
        // assertArrayEquals(no8,
        // myBTree.depthLeftOrder()[7].getElements().toArray(no8));
        // assertArrayEquals(no9,
        // myBTree.depthLeftOrder()[8].getElements().toArray(no9));
        // assertArrayEquals(no10,
        // myBTree.depthLeftOrder()[9].getElements().toArray(no10));
    }

}