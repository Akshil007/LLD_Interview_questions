import java.util.Scanner;

public class Vacation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1]  = sc.nextInt();
            arr[i][2]  = sc.nextInt();
        }
        System.out.println(maxHappiness(n, arr));
    }

    static int maxHappiness(int n, int[][] arr) {
        int dp[][] = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                int max = dp[i][j];
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        int a = dp[i - 1][k] + arr[i - 1][k];
                        max = Math.max(max, a);
                    }
                }
                dp[i][j] = max;
            }
        }
        return Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
    }
}
