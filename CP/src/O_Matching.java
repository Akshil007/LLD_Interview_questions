import java.util.Arrays;
import java.util.Scanner;

public class O_Matching {
    public static long mod = 1000000007;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int k = sc.nextInt();

        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max = (int)Math.pow(2,n);
        long[][] dp = new long[n+1][max+1];
//        for(long mat[][]:dp){
            for(long row[]:dp) {
                Arrays.fill(row, -1);
            }
//        }

        int x = (int)(rec(0, 0, arr, dp) % mod);
        System.out.println(x);
    }
    public static long rec(int i, int bitState, int arr[][], long[][] dp){
        if(i == arr.length)
            return 1;

        if(dp[i][bitState] !=-1)
            return dp[i][bitState];
        long sum = 0;
        for(int j=0;j< arr.length;j++){
            if(arr[i][j] == 1 && bitNotUsed(bitState,j)) {
                int newState = setBit(bitState, j);
                sum += (rec(i + 1, newState, arr,dp)%mod);
            }
        }
        return dp[i][bitState] = (sum%mod);
    }
    public static boolean bitNotUsed(int n, int pos){
        return ((n >> pos) & 1) == 0;
    }
    public static int setBit(int n, int pos){
        return ((1 << pos) | n);
    }

}
