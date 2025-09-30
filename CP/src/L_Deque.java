import java.util.Arrays;
import java.util.Scanner;

public class L_Deque{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        long total = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        long[][][] dp = new long[n+1][n+1][2];
        for(long row[][]:dp){
            for(long c[]:row) {
                Arrays.fill(c, -1);
            }
        }

        long x = rec(0, arr.length - 1,0, arr, dp);
        long y = total - x;
        System.out.println(x-y);
    }
    /*
    * Taro is trying to maximize (x-y) => taro is trying to maximize X's value
    * Jiro is trying to minimize (x-y) => Jiro is trying to maximize Y value
    * If we find X => Y = total - X
    * So we will play from taro's perspective only
    *
    * */
    public static long rec(int i, int j, int turn, int[] arr, long[][][] dp) {
        if (i > j) {
            return 0;
        }
        if(dp[i][j][turn] != -1)
            return dp[i][j][turn];
        // Taro's turn
        if(turn == 0) {
            // we try to maximize value
            long a1 = arr[i] + rec(i + 1, j, (turn+1)%2, arr, dp);
            long a2 = arr[j] + rec(i, j - 1, (turn+1)%2, arr, dp);
            return dp[i][j][turn] = Math.max(a1,a2);
        } else { // jiro's turn
            // we try to minimize value
            // Remember: we do not add arr[i] or arr[j] here, cause we are calculating only taro's value
            long a1 =  rec(i + 1, j, (turn+1)%2, arr, dp);
            long a2 =  rec(i, j - 1, (turn+1)%2, arr, dp);
            return dp[i][j][turn] = Math.min(a1,a2);
        }
    }

}
