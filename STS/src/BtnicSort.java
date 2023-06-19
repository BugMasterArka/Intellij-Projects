import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BtnicSort {
    static void sorter(int[] a){
        LinkedList<Integer> l = new LinkedList<>();
        for(int num:a)
            l.add(num);
        Collections.sort(l);
        System.out.println(l);
    }
    public static void main(String[] args) {
        int[] a = {1,5,4,7,9,2,3};
        sorter(a);
    }
}
