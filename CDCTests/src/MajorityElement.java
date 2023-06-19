import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for(int i=0;i< arr.length;i++)
            arr[i]=sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n: arr){
            if(map.containsKey(n))
                map.put(n,map.get(n)+1);
            else
                map.put(n,1);
        }
        int majority = arr.length/2;
        int count =0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()>majority){
                System.out.print(e.getKey()+" ");
                count++;
            }
        }
        if(count==0)
            System.out.println("-1");
    }
}
