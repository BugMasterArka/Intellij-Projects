import java.util.*;
import java.util.Stack;

public class Waiter {
//    public static List<Integer> waiter(List<Integer> number, int q) {
//        List<Integer> answers = new ArrayList<>();
//        int ansLast = 0;
//        int[] primes = {2,3,5,7,11,13,17,19,23,29};
//        ArrayList<Integer> Aworking = new ArrayList<>(number);
//        Stack<Integer> Aout = new Stack<>();
//        Stack<Integer> Bout = new Stack<>();
//        for(int i=0;i<q;i++){
//            if(Aworking.isEmpty())
//                break;
//            Aout.clear();
//            Bout.clear();
//            int curPrime = primes[i];
//            for(int n: Aworking){
//                if(n%curPrime==0)
//                    Bout.push(n);
//                else
//                    Aout.push(n);
//            }
//            Aworking.clear();
//            while(!Aout.isEmpty())
//                Aworking.add(0,Aout.pop());
//
//            while(!Bout.isEmpty())
//                answers.add(Bout.pop());
//
//            ansLast=answers.size();
//
//        }
//
//        while (!Aworking.isEmpty())
//            answers.add(Aworking.remove(0));
//
//        return answers;
//    }

    public static boolean isPrime(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    public static List<Integer> waiter(List<Integer> number, int q){
        List<Integer> answers = new ArrayList<>();

        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=10000;i++){
            if(isPrime(i))
                primes.add(i);
        }

        Stack<Integer> Aworking = new Stack<>();
        for(int n:number)
            Aworking.push(n);
        Stack<Integer> Aout = new Stack<>();
        Stack<Integer> Bout = new Stack<>();

        for(int i=0;i<q;i++){

            if(Aworking.isEmpty())
                break;
            Aout.clear();
            Bout.clear();


//            step 1
            int curPrime = primes.get(i);
            while(!Aworking.isEmpty()){
                int cur = Aworking.pop();
                if(cur%curPrime==0)
                    Bout.push(cur);
                else
                    Aout.push(cur);
            }

//            step 2
            while(!Bout.isEmpty()){
                answers.add(Bout.pop());
            }

//            step 3
            Stack<Integer> temp = new Stack<>();

            while(!Aout.isEmpty())
                temp.push(Aout.pop());

            while(!temp.isEmpty())
                Aworking.push(temp.pop());

        }
        while (!Aworking.isEmpty())
            answers.add(Aworking.pop());

        return answers;
    }

    public static void main(String[] args) {
        List<Integer> n = new ArrayList<>();
//        n.add(2);
//        n.add(3);
//        n.add(4);
//        n.add(5);
//        n.add(6);
//        n.add(7);


//        n.add(3);
//        n.add(3);
//        n.add(4);
//        n.add(4);
//        n.add(9);

        n.add(3);
        n.add(4);
        n.add(7);
        n.add(6);
        n.add(5);


        List<Integer> out = waiter(n,1);
        System.out.println(out);
    }
}
