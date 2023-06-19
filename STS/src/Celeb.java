import java.util.HashMap;
import java.util.Map;

public class Celeb {
    static void celebrity(int[][] a){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]==1) {
                    if (map.containsKey(j))
                        map.put(j, map.get(j) + 1);
                    else
                        map.put(j, 1);
                }
            }
        }
        int max=0;
        int celeb=0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()>max){
                max=e.getValue();
                celeb=e.getKey();
            }
        }
        System.out.println(celeb);
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,1,0},{0,0,1,0},{1,0,0,0},{0,0,1,0}};
        celebrity(a);
    }
}
