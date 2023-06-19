import java.util.Scanner;

public class MoveSpaces {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int spaceCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                spaceCount++;
        }
        String[] words = s.split(" ");
        System.out.print("^".repeat(spaceCount));
        for(String word: words)
            System.out.print(word);
    }
}
