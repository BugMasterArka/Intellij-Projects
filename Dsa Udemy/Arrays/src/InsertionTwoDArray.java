class TwoDimensionalArray1{
    int[][] arr=null;

    public TwoDimensionalArray1(int rows,int columns){
        arr=new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j]=Integer.MIN_VALUE;
            }
        }
    }

    public void insert(int row, int col, int val){
        try{
            if(arr[row][col]==Integer.MIN_VALUE){
                arr[row][col]=val;
                System.out.println("inserted");
            }else
                System.out.println("occupied");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("invalid index");
        }
    }
}
public class InsertionTwoDArray {
    
}
