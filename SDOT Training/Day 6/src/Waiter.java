import java.util.Stack;

public class Waiter {
    static int[] plating(int[] arr){
        int[] primes={2,3,5,7,11,13,17,19,23};
        int[] answers;
        int itr=0;
        while(arr.length!=0){
            Stack<Integer> s = new Stack<>();
            for(int i=0;i< arr.length;i++){
                if(arr[i]%primes[itr]==0)
                    s.push(arr[i]);
            }
            for()
        }
    }
}
