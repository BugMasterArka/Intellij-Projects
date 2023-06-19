import java.util.ArrayList;
import java.util.LinkedList;

public class SeparateNodes {
    static void separator(int[] a){
        String out1 ="",out2 = "";
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0)
                out1=out1.concat(String.valueOf(a[i])+" ");
            else
                out2=out2.concat(String.valueOf(a[i])+" ");
        }
        out1=out1.concat(out2);
        System.out.println(out1);
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        separator(a);
    }
}
