import java.util.Stack;

public class MinStack2 {
    static Stack<Integer> s = new Stack<>();
    static int me = 0;
    static void push(int n){
        if(s.empty()){
            s.push(n);
            me = n;
        }else if(n<me){
            s.push(2*n-me);
            me=n;
        }else{
            s.push(n);
        }
    }

    static void pop(){
        if(s.empty())
            System.out.println("Stack empty");
        else{
            int y = s.pop();
            if(y<me){
                me = 2*me-y;
            }
        }
    }
    static void getMin(){
        System.out.println(me);
    }

    public static void main(String[] args) {
        push(5);
        push(7);
        push(9);
        getMin();
        push(3);
        getMin();
        push(1);
        getMin();
        pop();
        pop();
        pop();
        getMin();
    }
}
