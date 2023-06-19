public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        int a = (2*numRows)-3;
        int b = 0;
        String out="";
        for(int i=1;i<=numRows;i++){
            int j=0;
            int flg=0;
            while(j<s.length()){
                if(flg%2==0){
                    out=out+s.charAt(j);
                    if(a!=0)
                        j=j+a+1;
                    else
                        j=j+b+1;
                    flg++;
                }else{
                    out=out+s.charAt(j);
                    if(b!=0)
                        j=j+b+1;
                    else
                        j=j+a+1;
                    flg++;
                }
            }
            if(a-2<0)
                a=0;
            else
                a-=2;
            if(b==0)
                b=1;
            else
                b+=2;
            s=s.substring(1,s.length());
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        s = convert(s,5);
        System.out.println(s);
    }
}
