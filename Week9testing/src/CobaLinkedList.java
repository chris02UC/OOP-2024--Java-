import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;



public class CobaLinkedList {
    private LinkedList<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        for (int a = 0; a < 3; a++){
            int input = s.nextInt();
            list.addLast(input); // if addfirst, new inputs is put on top (input 1,2,3 becomes 3,2,1)
        }

            //if use listiterator
        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        //if use iterator
        Iterator<Integer> it2 = list.iterator();
        int sum = 0;
        while( it2.hasNext() ){ // check if it has a next element
        sum += it2.next(); // next element
        }
        System.out.println("the sum is "+sum);

        //showing list elements
        // Iterator it = list.iterator();
        // while(list.iterator().hasNext()){
        //     System.out.println(list.iterator().next());
        // }
    }
}
