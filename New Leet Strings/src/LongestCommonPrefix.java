//problem: https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    static String getCommon(String s,int i){
        return s.substring(0,i);
    }

    static int getSmallest(String[] strs){
        int index=0,minLength=Integer.MAX_VALUE;
        for(int i=0;i< strs.length;i++){
            if(strs[i].length()<minLength){
                minLength=strs[i].length();
                index=i;
            }
        }
        return index;
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        for(int i=0;i<strs.length;i++)
            if(strs[i].equalsIgnoreCase(""))
                return "";
        int i=0;
        int index = getSmallest(strs);
        while(strs[0].charAt(i)==strs[index==0?1:index].charAt(i)){
            i++;
            if(i==strs[index].length())
                break;
        }
        for(int j=0;j< strs.length;j++){
            if(!strs[j].substring(0,i).equalsIgnoreCase(getCommon(strs[index],i))){
                for(int k=i-1;k>=0;k--){
                    if(strs[j].charAt(k)!=getCommon(strs[index],i).charAt(k))
                        i--;
                }
            }
        }
        return getCommon(strs[index],i);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","fkow"};
        System.out.println(longestCommonPrefix(strs));
    }
}
