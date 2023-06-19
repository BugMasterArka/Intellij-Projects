import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSlidingWindow {

    static int[] WindowMax(int[] a,int k){
        int[] out = new int[a.length-k+1];
        int outIndex=0;
        for(int i=0;i<a.length-k+1;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=i;j<i+k;j++){
                list.add(a[j]);
            }
            out[outIndex++]=Collections.max(list);
        }
        return out;
    }
    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(WindowMax(a,3)));
    }
}
