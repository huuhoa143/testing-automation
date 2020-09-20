public class BoundedQueue {
    private final Object[] elements;
    private int size, front, back;
    private final int capacity;

    public BoundedQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("BoundedQueue.constructor");
        }

        this.capacity = capacity;
        elements = new Object[capacity];
        size = 0;
        front = 0;
        back = 0;
    }

    public void enQueue (Object o) throws NullPointerException, IllegalStateException {
        if (o == null)
            throw new NullPointerException ("BoundedQueue.enQueue");
        else if (size == capacity)
            throw new IllegalStateException ("BoundedQueue.enQueue");
        else {
            size++;
            elements [back] = o;
            back = (back+1) % capacity;
        }
    }

    public Object deQueue () throws IllegalStateException {
        if (size == 0)
            throw new IllegalStateException ("BoundedQueue.deQueue");
        else {
            size--;
            Object o = elements [ (front % capacity) ];
            elements [front] = null;
            front = (front+1) % capacity;
            return 0;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++)
        {
            result += elements[ (front + i) % capacity ] . toString();
            if (i < size -1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
