import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DeletionArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A","B","C","D","E"));

        System.out.println(list.remove("D"));
        System.out.println(list.remove(1));
        list.sort(Comparator.naturalOrder());

    }
}
