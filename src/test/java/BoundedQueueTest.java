import org.junit.Test;
import static org.junit.Assert.*;

public class BoundedQueueTest {

    @Test
    public void testEnQueue() {
        System.out.println("enQueue");
        Object o  = 1;
        BoundedQueue instance = new BoundedQueue(5);
        instance.enQueue(o);

        assertEquals(instance.toString(), "[1]");
    }

    @Test
    public void testDeQueue() {
        System.out.println("deQueue");

        Object o = 1;
        Object a = 2;
        BoundedQueue instance = new BoundedQueue(5);
        instance.enQueue(o);
        instance.enQueue(a);
        instance.deQueue();

        assertEquals(instance.toString(), "[2]");
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");

        BoundedQueue instance = new BoundedQueue(5);

        assertTrue(instance.isEmpty());
    }

    @Test
    public void testIsFull() {
        System.out.println("isFull");
        Object a = 1;
        BoundedQueue instance = new BoundedQueue(5);
        instance.enQueue(a);
        instance.enQueue(a);
        instance.enQueue(a);
        instance.enQueue(a);
        instance.enQueue(a);

        assertTrue(instance.isFull());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Object o = 1;
        Object a = 2;
        Object b = 4;
        BoundedQueue instance = new BoundedQueue(5);
        instance.enQueue(a);
        instance.enQueue(b);
        instance.enQueue(o);
        assertEquals(instance.toString(), "[2, 4, 1]");
    }
}
