import java.util.ArrayList;
import java.util.Iterator;

public class TraversingArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        for(String s: list)
            System.out.print(s+" ");
        System.out.println();
        Iterator<String> i = list.iterator();
        while(i.hasNext())
            System.out.print(i.next()+" ");
    }
}
