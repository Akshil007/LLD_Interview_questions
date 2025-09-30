import java.util.Arrays;
import java.util.Scanner;

public class Knapsack_2 {
    static long INF = 10^9 + 5;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();

        // weight, value
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1]  = sc.nextInt();
        }
        System.out.println(bottomUp(n, W, arr));
    }

    static long bottomUp(int n, int w, int[][] arr) {
        int maxvalue = 1000 * n;
        long INF = 10^9 + 5;
        long dp[][] = new long[n + 1][maxvalue + 1];
        // for current item i, choose min possible total weight with total value <= j
        for(long row[]:dp){
            Arrays.fill(row, INF);
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxvalue; j++) {
                if(arr[i-1][1] <= j){
                    dp[i][j] = Math.min(dp[i-1][j], arr[i-1][0] + dp[i-1][j-arr[i-1][1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][w]);
        for (int j = maxvalue; j >= 0 ; j--) {
            if(dp[n][j] <= w)
                return j;
        }
        return -1;
    }

    static long rec(int i, int value_left, int n, int[][] arr){
        if(value_left == 0)
            return 0;
        if(i<0 || value_left < 0)
            return INF;

        // not choose
        long a = rec(i-1, value_left, n, arr);

        //choose
        long b = rec(i-1, value_left - arr[i][1], n, arr) + arr[i][0];
        return Math.min(a,b);
    }

}
