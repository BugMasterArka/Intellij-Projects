import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] arr){
        for(int i=0;i< arr.length;i++){
            int minIndex = i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }
            if(arr[minIndex]<arr[i]){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,7,4,9,5,6,1,8,3,2};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
