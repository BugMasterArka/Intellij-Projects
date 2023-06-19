import java.util.ArrayList;
import java.util.Stack;

public class StackPermutation {
    static boolean StackPermute(int[] a,int[] b){
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean valid=true;
        for(int num:a)
            s.push(num);
        for(int num:b)
            list.add(num);
        while(valid && !s.empty()){
            if(!list.contains(s.pop()))
                valid=false;
        }
        return valid;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,4,3,6,2};
        System.out.println(StackPermute(a,b));
    }
}
