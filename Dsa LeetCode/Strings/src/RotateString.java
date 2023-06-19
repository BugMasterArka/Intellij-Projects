public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if(goal.equalsIgnoreCase(s))
            return true;
        String original = s;
        do{
            s = s.substring(1,s.length()).concat(s.substring(0,1));
            if(s.equalsIgnoreCase(goal))
                return true;
        }while(!s.equalsIgnoreCase(original));
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab"));
    }
}
