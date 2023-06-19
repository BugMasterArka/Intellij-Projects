import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualStacks {
    public static int sum(List<Integer> list){
        int sum=0;
        for(int n: list)
            sum+=n;
        return sum;
    }

    public static void equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int ht1 = sum(h1);
        int ht2 = sum(h2);
        int ht3 = sum(h3);

        while(true){
            if(ht1==ht2 && ht2==ht3){
                System.out.println(ht1);
                break;
            }

            int minHt = Math.min(ht1,Math.min(ht2,ht3));

            if(ht1>minHt){
                ht1-=h1.get(0);
                h1.remove(0);
            }

            if(ht2>minHt){
                ht2-=h2.get(0);
                h2.remove(0);
            }

            if(ht3>minHt){
                ht3-=h3.get(0);
                h3.remove(0);
            }
        }

    }

    public static void main(String[] args) {
        int[] a1 = {3,2,1,1,1};
        List<Integer> h1 = new ArrayList<>();
        h1.add(3);
        h1.add(2);
        h1.add(1);
        h1.add(1);
        h1.add(1);
        List<Integer> h2 = new ArrayList<>();
        h2.add(4);
        h2.add(3);
        h2.add(2);
        List<Integer> h3 = new ArrayList<>();
        h3.add(1);
        h3.add(1);
        h3.add(4);
        h3.add(1);

        equalStacks(h1,h2,h3);
    }
}

