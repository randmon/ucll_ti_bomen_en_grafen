package domain;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> boom;

    @Before
    public void setUp() throws Exception {
        boom = new BinarySearchTree<>(6);
        boom.addNode(4);
        boom.addNode(8);
        boom.addNode(3);
        boom.addNode(5);
        boom.addNode(7);
        boom.addNode(9);
        boom.addNode(10);
        boom.addNode(11);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeNode_NullData_gooitException() {
        boom.removeNode(null);
    }

    @Test
    public void removeNode_notInBoom_returnsFalse() {
        assertFalse(boom.removeNode(1000));
    }

    @Test
    public void removeNode_inBoom_returnsTrue() {
        assertTrue(boom.removeNode(3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addNode_NullData_gooitException() {
        boom.addNode(null);
    }

    @Test
    public void addNode_AlreadyExistingData_returnsFalse() {
        assertFalse(boom.addNode(6));
    }

    @Test
    public void addNode_correctNode_returnsTrue() {
        assertTrue(boom.addNode(1000));
    }

    @Test (expected = IllegalArgumentException.class)
    public void lookUp_nullNode_gooitException() {
        boom.lookup(null);
    }

    @Test
    public void lookUp_nodeNotInTree_returnsFalse() {
        assertFalse(boom.lookup(1000));
    }

    @Test
    public void lookUp_nodeInTree_returnsTrue() {
        assertTrue(boom.lookup(6));
        boom.addNode(1000);
        assertTrue(boom.lookup(1000));
    }

    @Test
    public void lookUp_justRemovedNode_returnsFalse() {
        assertTrue(boom.lookup(6));
        assertTrue(boom.lookup(5));

        boom.removeNode(6);
        boom.removeNode(5);

        assertFalse(boom.lookup(6));
        assertFalse(boom.lookup(5));
    }

    @Test
    public void countNodes_afterRemoving_minusOne() {
        int count = boom.countNodes();
        boom.removeNode(3);
        assertEquals(count-1, boom.countNodes());
        boom.removeNode(9);
        assertEquals(count-2, boom.countNodes());
    }

    @Test (expected = IllegalArgumentException.class)
    public void getPath_nullData_gooitException() {
        boom.getPath(null);
    }

    @Test
    public void getPath_nonExistingData_returnsNull() {
        assertNull(boom.getPath(1000));
        assertNull(boom.getPath(-1000));
    }

    @Test
    public void getPath_goodPaths() {
        assertEquals(new ArrayList<Integer>() {{add(6);}}, boom.getPath(6));
        assertEquals(new ArrayList<Integer>() {{add(6);add(8);}}, boom.getPath(8));
        assertEquals(new ArrayList<Integer>() {{add(6);add(4);}}, boom.getPath(4));
        assertEquals(new ArrayList<Integer>() {{add(6);add(4);add(5);}}, boom.getPath(5));
    }
}