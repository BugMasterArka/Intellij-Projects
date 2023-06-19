import java.util.ArrayList;

public class InsertionInArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(1,4);
        System.out.println(l);
        try{
            l.add(6,5);
        }catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBoundsException");
        }
    }
}
