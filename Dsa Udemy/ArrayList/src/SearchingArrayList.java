import java.util.ArrayList;
import java.util.Arrays;

public class SearchingArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A","B","C","D","E"));

        for(int i=0;i<list.size();i++)
            if(list.get(i)=="C")
                System.out.println("found");

        for(String s: list)
            if(s.equalsIgnoreCase("c"))
                System.out.println("found");

        System.out.println(list.indexOf("C"));

        System.out.println(list.contains("C "));
    }
}
