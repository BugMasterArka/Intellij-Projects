import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndOrXor {

    public static int[] get2Min(List<Integer> a){
        int[] out = new int[2];
        Collections.sort(a);
        out[0]=a.get(0);
        out[1]=a.get(1);
        return out;
    }

    public static int giveSi(int[] arr){
        return ((arr[0]&arr[1])^(arr[0]|arr[1]))&(arr[0]^arr[1]);
    }

    public static List<Integer> makeInterval(int start, int end,List<Integer> list){
        List<Integer> out = new ArrayList<>();
        for(int i=start;i<=end;i++)
            out.add(list.get(i));
        return out;
    }

    public static int andXorOr(List<Integer> a) {
        int maxS = 0;
        int size=1;
        while(size<a.size()){
            int j=0;
            while(j+size<a.size()){
                int si = giveSi(get2Min(makeInterval(j,j+size,a)));
                if(si>maxS)
                    maxS=si;
                j++;
            }
            size++;
        }
        return maxS;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(9);
        l.add(6);
        l.add(3);
        l.add(5);
        l.add(2);
        System.out.println(andXorOr(l));
    }
}
