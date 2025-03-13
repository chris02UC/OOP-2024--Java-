import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class CobaHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> kamus = new HashMap<>();
        // Hashtable<Integer, String> kamus = new Hashtable<>();
        kamus.put(1, "Daffa");
        kamus.put(10, "Darren");
        kamus.put(21, null);
        kamus.put(null, "Surya");

        for (Integer key: kamus.keySet()){
            // System.out.println(kamus.get(key));
            System.out.println(key + "\t"+kamus.get(key));
        }

        // ArrayList<Integer> angka = new ArrayList();
        // // angka.add(1);
        // angka.add(3);
        // angka.add(2);
        // angka.add(1);
        // angka.add(3);
        // angka.add(1);

        // System.out.println("Angka di list");
        // for (int a : angka){
        //     System.out.println(a);
        // }

        // System.out.println("Angka di set");
        // // Set<Integer> angka2 = new HashSet(angka);
        // Set<Integer> angka2 = new TreeSet(angka);
        // for (int a :angka2){
        //     System.out.println(a);
        // }

        // HashMap<String, ArrayList<String>> kamus = new HashMap<String, ArrayList<String>>();
        // ArrayList<String> arrA = kamus.get("a");
        // if (arrA==null){
        //     arrA = new ArrayList<String>();
        // }
        // arrA.add("aku");
        // kamus.put("a", arrA);

        // for (String key: kamus.keySet()){
        //     ArrayList<String> arr = kamus.get(key);
        //     for (String kata: arr){
        //         System.out.println(kata);
        //     }
        // }

        // HashMap<String, String> kamus = new HashMap<String, String>();
        // kamus.put("a", "aku");
        // kamus.put("b", "baik");
        // kamus.put("c", "cantik");
        // kamus.putIfAbsent("a", "anda");


        // for (String key: kamus.keySet()){
        //     String val = kamus.get(key);
        //     System.out.println(val);
        //     System.out.println(kamus.get(key));
        // }

    }
}
