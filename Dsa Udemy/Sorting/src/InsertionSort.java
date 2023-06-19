import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,8,10,2,7,3,9,1,4,6};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
