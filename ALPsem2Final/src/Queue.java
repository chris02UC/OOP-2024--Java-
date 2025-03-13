import java.util.LinkedList;

public class Queue {
    private LinkedList<Object> list = new LinkedList<Object>();
    private int count = 0; 

    public void enqueue(Object o) {
        list.addLast(o);
        count++; 
    }

    public Object dequeue() {
        if (!isEmpty()) {
            count--; 
            return list.removeFirst();
        }
        return null;
    }

    public Object peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return count; 
    }
}

