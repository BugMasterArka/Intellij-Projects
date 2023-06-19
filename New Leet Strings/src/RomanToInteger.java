//problem: https://leetcode.com/problems/roman-to-integer/

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int n=0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i=0;i<s.length();){
            if(i<s.length()-1){
                if(s.charAt(i)=='I' && s.charAt(i+1)=='V'){
                    n+=4;
                    i+=2;
                }
                else if(s.charAt(i)=='I' && s.charAt(i+1)=='X'){
                    n+=9;
                    i+=2;
                }
                else if(s.charAt(i)=='X' && s.charAt(i+1)=='L'){
                    n+=40;
                    i+=2;
                }
                else if(s.charAt(i)=='X' && s.charAt(i+1)=='C'){
                    n+=90;
                    i+=2;
                }
                else if(s.charAt(i)=='C' && s.charAt(i+1)=='D'){
                    n+=400;
                    i+=2;
                }
                else if(s.charAt(i)=='C' && s.charAt(i+1)=='M'){
                    n+=900;
                    i+=2;
                }else{
                    n+=map.get(s.charAt(i));
                    i++;
                }
            }
            else{
                n+=map.get(s.charAt(i));
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
