import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        APList list = new APList(10);
        list.add("A");
        list.add("B");

        list.add("C",3); // can't do
        list.add("C",2); // A B C   inserts at the end
        list.add("D",2); // A B D C
        list.add("E",1); // A E B D C
        list.add("F",0); // F A E B D C

        System.out.print( list.get(6) ); // can't do
        System.out.print( list.get(-1) ); // can't do
        System.out.println( list.get(5) ); // C
        System.out.println( list.get(0) ); // F

        System.out.println("Contains Z: " + list.contains("Z")); // false
        System.out.println("Contains F: " + list.contains("F")); // true
        System.out.println("Contains C: " + list.contains("C")); // true

        list.remove("Z"); // can't do
        list.remove("C");
        list.remove("F");
        System.out.println( list.size() + "/" + list.capacity() + " " + list.toString() );

        list.remove(-1); // can't do
        list.remove(4);  // can't do
        System.out.println("Removing element at index 0: " +  list.remove(0) );  // E B D
        System.out.println("Removing element at index 2: " +  list.remove(2) );  // E B
        System.out.println( list.size() + "/" + list.capacity() + " " + list.toString() );
    }
}

