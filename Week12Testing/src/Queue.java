import java.util.LinkedList;

public class Queue {
    private LinkedList<Object> list = new LinkedList<Object>();

    public void enqueue(Object o){
        list.addLast(o);
    }

    public Object dequeue(){
        return list.removeFirst();
    }

    public Object peek(){
        return list.getFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
