import java.util.Scanner;

public class Knapsack_1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1]  = sc.nextInt();
        }
        System.out.println(bottomUp(n, W, arr));
    }

    static long bottomUp(int n, int w, int[][] arr) {
        long dp[][] = new long[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if(arr[i-1][0] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], arr[i-1][1] + dp[i-1][j-arr[i-1][0]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
//    void rec(int total, int i){
//        if(total > W || i > N)
//            return 0;
//        if(arr[i][1]<=w){
//            rec(i+1), rec(i+1) + v
//        }
//    }
}
