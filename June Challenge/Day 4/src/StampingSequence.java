//problem: https://www.hackerrank.com/contests/vit-ap-week-1/challenges/stamping-the-sequence

//solution: https://youtu.be/EtalsGoNrBI

import java.util.ArrayList;
import java.util.Arrays;

public class StampingSequence {

    public static int[] stamp(String stamp, String target){
        char[] tchar = target.toCharArray();
        char[] schar = stamp.toCharArray();
//        to check the number of question marks
        int count =0;

//        to check if the position is already visited
        boolean[] visited = new boolean[tchar.length];

//        to store the locations from where we stamp
        ArrayList<Integer> l = new ArrayList<>();

//        to check if we changed anything
        boolean didChange = false;

//        tchar.length - schar.length because the stamp can start only upto this length as it won't fit otherwise
        for(int i=0;i<=tchar.length - schar.length;i++){

//            if location not visited and the node can be replaced
            if(!visited[i] && canReplace(tchar, i, schar)){
                count = replace(tchar,i, schar.length, count);
                visited[i]=true;
                didChange = true;
                l.add(i);
            }
//            if we reached our goal number of '?'
            if(count == tchar.length)
                break;
        }
        System.out.println(l);
        int[] result = new int[l.size()];
        int k=0;
        for(int i=l.size()-1;i>=0;i--){
            result[k++]=l.get(i);
        }

        return result;
    }

    public static boolean canReplace(char[] tchar, int pos, char[] schar){

//        iterating the length of stamp
        for(int i=0;i< schar.length;i++){

//            pos = position to be checked
//            i = counter to check same position in stamp

//            if i+pos location is not ? then it cannot be replaced as '?' can be assumed any character
//            if i+pos location is not same as iTH position in stamp we shouldn't replace it
            if(tchar[i+pos]!='?' && tchar[i+pos]!=schar[i])
                return false;
        }
        return true;
    }

    public static int replace(char[] tchar, int pos, int len,int count){
        for(int i=0;i<len;i++){
            if(tchar[i+pos]!='?'){
                tchar[i+pos]='?';
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(stamp("abca","aabcaca")));
    }
}
