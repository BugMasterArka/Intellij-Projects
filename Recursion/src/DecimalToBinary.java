import java.util.Scanner;

public class DecimalToBinary {
    static int convert(int n){
        if(n<0)
            return -1;
        if(n==0)
            return 0;
        else
            return 10*convert(n/2)+(n%2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(convert(n));
    }
}
