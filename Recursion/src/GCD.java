import java.util.Scanner;

public class GCD {
    static int find(int a, int b){
        if(b==0)
            return a;
        else
            return find(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(find(a,b));
    }
}
