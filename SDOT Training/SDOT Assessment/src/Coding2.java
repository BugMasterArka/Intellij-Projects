/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Coding2
{
    public static void reverse(int[] arr){
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int j=0;j<size;j++)
                arr[j]=sc.nextInt();
            reverse(arr);
            for(int j=0;j<size;j++)
                System.out.print(arr[j]+" ");
            System.out.println();
            sc.nextLine();
        }
    }
}