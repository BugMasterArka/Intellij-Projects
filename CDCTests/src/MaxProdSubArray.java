import java.util.Scanner;

public class MaxProdSubArray {
    public static int product(int[] arr,int start,int size){
        int prod = 1;
        for(int i=start;i<=size;i++)
            prod*=arr[i];
        return prod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int maxProd=0;
        for(int i=1;i< arr.length-1;i++){
            for(int j=0;j< arr.length-i-1;j++){
                int prod = product(arr,j,i);
                if(prod>maxProd) {
                    maxProd=prod;
                }
            }
        }
        System.out.println(maxProd);
    }
}
