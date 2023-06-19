import java.util.*;
import java.lang.*;

public class Coding3
{
    public static void main (String[] args)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){

            ArrayList<Integer> l = new ArrayList<>();
            int size = sc.nextInt();
            for(int j=0;j<size;j++)
                l.add(sc.nextInt());
            list.add(l);
            sc.nextLine();
        }

        for(int i=0;i<n;i++){
            Collections.reverse(list.get(i));
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<list.get(i).size();j++)
                System.out.print(list.get(i).get(j)+" ");
            System.out.println();
        }
    }
}
