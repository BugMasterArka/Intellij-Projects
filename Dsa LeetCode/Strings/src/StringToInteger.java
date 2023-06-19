//problem: https://leetcode.com/problems/string-to-integer-atoi/description/

//solution: https://www.youtube.com/watch?v=qZoFJKyHQ98

//solution: https://www.youtube.com/watch?v=VYsSowFwZVU

public class StringToInteger {
    public static int myAtoi(String s) {
        int len = s.length();
        if(len==0)
            return 0;
        int i=0;
        int result = 0;
        int sign = 1;
        while(i<len && s.charAt(i)==' ')
            i++;
        if(i<len && s.charAt(i)=='-') {
            i++;
            sign = -1;
        }else if(i<len && s.charAt(i)=='+'){
            i++;
        }
        while(i<len && s.charAt(i)=='0')
            i++;
        while(i<len && Character.isDigit(s.charAt(i))){
            int digit = Integer.parseInt(s.substring(i,i+1));
            if(result>Integer.MAX_VALUE/10 || result==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            result=result*10+digit;
            i++;
        }
        return result*sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
    }
}
