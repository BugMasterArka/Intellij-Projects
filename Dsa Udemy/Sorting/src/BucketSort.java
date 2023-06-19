import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void printBuckets(ArrayList<Integer>[] buckets){
        for(ArrayList<Integer> bucket: buckets){
            for(int elem: bucket){
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }

    public static void sort(int[] arr){
        int numberOfBuckets = (int)Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;

        for(int num: arr){
            if(num>maxValue)
                maxValue=num;
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new ArrayList<>();
        }

        for(int val: arr){
            int bucketNumber = (int)Math.ceil(((float)val*numberOfBuckets)/((float) maxValue));
            buckets[bucketNumber-1].add(val);
        }

        printBuckets(buckets);

        for(ArrayList<Integer> bucket: buckets)
            Collections.sort(bucket);

        printBuckets(buckets);

        int index = 0;
        for(ArrayList<Integer> bucket: buckets){
            for(int num: bucket)
                arr[index++] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,6,8,2,9,4,5,1,3,7};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
