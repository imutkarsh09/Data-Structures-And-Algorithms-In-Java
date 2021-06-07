import java.util.*;
public class N_Queens
{
    public static void printNQueens(int[][] chess, String asf, int row)
    {
        if(row==chess.length)
        {
            System.out.println(asf+".");
            return;
        }
        for(int col = 0;col<chess.length;col++)
        {
            if(isPositionSafe(chess, row,col)==true)
            {
            chess[row][col] = 1;
            printNQueens(chess,asf+row+"-"+col+", ",row+1);
            chess[row][col] = 0;
            }
        }
    }
    public static boolean isPositionSafe(int[][] chess,int row, int col)
    {
        for(int i = row-1, j= col;i>=0; i--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row-1, j = col-1;i>=0 && j>=0;i--, j--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row-1, j = col+1;i>=0 && j<chess.length;i--,j++)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess,"",0);
    }
}