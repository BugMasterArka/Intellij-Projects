import java.util.*;

public class Coding1 {

    public static int maxSumStack(List<Integer> sumstack){
        int max=0,index=0;
        for(int i=0;i<sumstack.size();i++){
            if(sumstack.get(i)>max){
                max=sumstack.get(i);
                index=i;
            }
        }
        return index;
    }

    public static boolean isSumEqual(List<Integer> sumstack){
        int sum=0;
        for(int i=0;i<sumstack.size();i++){
            if(i==0) sum=sumstack.get(i);
            else{
                if(sumstack.get(i)!=sum)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[3];
        n[0] = sc.nextInt();
        n[1] = sc.nextInt();
        n[2] = sc.nextInt();

        sc.nextLine();

        Stack<Integer> ipstack = new Stack<>();

        List<Stack<Integer>> list = new ArrayList<>();
        List<Integer> sumstack = new ArrayList<>();
        for(int i=0;i<3;i++){
            Stack<Integer> s = new Stack<>();
            int j=0;
            int sum=0;
            while(j<n[i]){
                int val = sc.nextInt();
                sum+=val;
                ipstack.push(val);
                j++;
            }
            while(!ipstack.empty())
                s.push(ipstack.pop());
            sumstack.add(sum);
            list.add(s);
            sc.nextLine();
        }

        while(!isSumEqual(sumstack)){
            int maxSumStackIndex = maxSumStack(sumstack);
            int MaxSumStackTop = list.get(maxSumStackIndex).pop();
            int newSum = sumstack.get(maxSumStackIndex)-MaxSumStackTop;
            sumstack.remove(maxSumStackIndex);
            sumstack.add(maxSumStackIndex,newSum);
        }

        System.out.println(sumstack.get(0));
    }
}
