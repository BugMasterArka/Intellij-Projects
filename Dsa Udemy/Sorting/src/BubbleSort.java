import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,5,1,7,3,4,2,9,8,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
