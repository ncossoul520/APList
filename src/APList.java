import java.util.Arrays;

public class APList {

    private String[] list;
    private int next;

    public APList (int size) {
        list = new String[ size ];
        next = 0;
    }

    // add value to the end of the list
    public void add(String value) {
        if ( next == list.length ) {
            System.out.println("WARNING: cannot add, list is full");
            return;
        }
        list[ next++ ] = value;
    }

    // insert value at index.  All elements at index and larger shift right to accommodate.
    public void add(String value, int index) {
        if ( index > next || index < 0 ) {
            System.out.println("WARNING: cannot add at an index greater than last index (" + next + ")");
            return;
        }
        for (int i = next; i > index ; i--) {
            list[i] = list[i-1];
        }
        list[index] = value;
        next++;
    }

    // return the element at index
    public String get(int index) {
        if ( index < 0 || index >= next ) {
            System.out.println("WARNING: cannot get value at index: " + index);
            return "";
        }
        return list[index];
    }


    // return true if list contains value
    public boolean contains(String value){
        for (int i = 0; i < next; i++) {
            if ( list[i].equals( value ) ) {
                return true;
            }
        }
        return false;
    }

    // remove the first occurrence of value from your list, all larger values shift down
    public void remove(String value) {
        if ( !contains( value ) ) {
            System.out.println("WARNING: cannot find value to remove: " + value);
            return;
        }
        for (int i = 0; i < next; i++) {
            if (list[i].equals(value)) {
                remove(i);
            }
        }
    }

    // remove value at index and return it, all larger values shift down
    public String remove(int index) {
        if ( index < 0 || index >= next ) {
            System.out.println("WARNING: cannot remove element at index: " + index);
            return "";
        }
        String out = list[index];
        for (int i = index; i < next; i++) {
            list[i] = list[i+1];
        }
        next--;
        list[next] = null;
        return out;
    }

    // return the number of elements in your list
    public int size() {
       return next;
    }

    // return the max capacity of your list
    public int capacity() {
        return list.length;
    }

    public String toString() {
        return Arrays.toString( list );
    }

    public void clear() {
        list = new String[ list.length ];
        next = 0;
    }
}