import java.util.Scanner;

public class MinStack {
    static int[] s;
    static int top;
    static int n;
    static int me=0;
    static{
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of values");
        n = sc.nextInt();
        s = new int[n];
        top = -1;
    }
    static void push(int num){
        if(top==n-1)
            System.out.println("Stack full");
        else if(top==-1){
            s[++top]=num;
            me = num;
        }
        else if(num<me){
            s[++top]=2*num-me;
            me=num;
        }
        else{
            s[++top]=num;
        }
    }

    static void pop(){
        if(top==-1)
            System.out.println("Stack empty");
        else{
            int y = s[top];
            top--;
            if(y<me)
                me = 2*me-y;
        }
    }

    static void getMin(){
        System.out.println(me);
    }

    public static void main(String[] args) {
        push(5);
        push(7);
        push(9);
        push(3);
        getMin();
        pop();
        pop();
        pop();
        getMin();
    }

}
