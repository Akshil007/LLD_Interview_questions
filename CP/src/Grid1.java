import java.util.Scanner;

public class Grid1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        // weight, value
        int[][] arr = new int[r][c];
        for(int i=0;i<r;i++){
            String row = sc.next();
            for(int j=0;j<c;j++){
                if(row.charAt(j) == '#')
                    arr[i][j] = 1;
            }
        }
        System.out.println(getTotalPaths(arr, r, c));
    }

    public static int getTotalPaths(int grid[][], int n, int m){
        int dp[][] = new int[n+1][m+1];
        int mod = 1000000007;
        dp[0][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(grid[i-1][j-1]!=1){
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
                }
            }
        }
        return dp[n][m];
    }
}
