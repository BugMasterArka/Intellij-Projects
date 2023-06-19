import java.util.Scanner;

public class ProjectArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many days");
        int n = sc.nextInt();
        double[] arr = new double[n];
        double avg=0;
        for(int i=0;i<n;i++){
            System.out.println("Enter day "+(i+1)+" temp :");
            double temp = sc.nextDouble();
            arr[i]= temp;
            avg+=temp;
        }
        avg/=n;
        for(int i=0;i<n;i++){
            if(arr[i]>avg)
                System.out.println("day "+(i+1)+" temp is higher than avg");
        }
    }
}
