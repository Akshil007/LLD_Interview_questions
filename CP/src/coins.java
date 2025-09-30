import java.util.Arrays;
import java.util.Scanner;

public class coins {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // weight, value
        double[] p = new double[n];
        for(int i=0;i<n;i++){
            p[i] = sc.nextDouble();
        }

        double[][] dp = new double[n+1][n+1];
        for(double[] row: dp){
            Arrays.fill(row, -1.0);
        }

        System.out.println(rec(0, 0, n, p, dp));
    }
    public static double rec(int i, int count, int n, double[] p, double[][] dp){
        if(i == n){
            if(count > (int)(n/2))
                return 1.0;
            else
                return 0.0;
        }
        if(dp[i][count] != -1)
            return dp[i][count];
        double pHead = p[i] * rec(i+1, count+1, n, p, dp);
        double pTail = (1 - p[i]) * rec(i+1, count, n, p, dp);
//        System.out.println(pHead+" "+pTail);
        return dp[i][count] = pHead + pTail;
    }
//    public static double bottomup(int n, double[] p){
//        double[][] dp = new double[n+1][(n/2)+2];
//        for(int i=0;i<=n;i++){
//            dp[i][(n/2)+1] = 1.0;
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<)
//        }
//
//
//    }
}
