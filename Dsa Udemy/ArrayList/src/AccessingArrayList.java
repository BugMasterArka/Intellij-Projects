import java.util.ArrayList;

public class AccessingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(1,4);
        System.out.println(l);
        System.out.println(l.get(2));
        System.out.println(l.get(0));
    }
}
