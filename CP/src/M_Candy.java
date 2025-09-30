import java.util.Arrays;
import java.util.Scanner;

public class M_Candy {
    public static long mod = 1000000007;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        long total = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        long[][] dp = new long[n+1][k+1];
        for(long row[]:dp){
            Arrays.fill(row, -1);
        }

        int x = (int)(rec(0, k, arr, dp) % mod);
        System.out.println(x);
    }
    public static long rec(int i, int k, int arr[], long[][] dp){
        if(k == 0)
            return 1;
        if(i == arr.length)
            return 0;
        if(dp[i][k]!=-1)
            return dp[i][k];
        long sum = 0;
        for(int j=0;j<=arr[i];j++){
            if(k-j>=0) {
                sum += (rec(i + 1, k-j,arr, dp)%mod);
            }
        }
        return dp[i][k] = (sum%mod);
    }
}
