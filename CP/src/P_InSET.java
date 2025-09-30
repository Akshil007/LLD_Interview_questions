import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P_InSET {
    public static long mod = 1000000007;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int k = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

//        int[][] edges = new int[n][n];
        for(int i=0;i<n-1;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
//            System.out.println(i);
        }

//        int max = (int)Math.pow(2,n);
        long[][] dp = new long[n+1][2];
//        for(long mat[][]:dp){
            for(long row[]:dp) {
                Arrays.fill(row, -1);
            }
//        }

        int x = (int)(((rec(1, 0, n-1, graph, dp) % mod) + (rec(1, 1, n-1, graph, dp) % mod)) % mod);
        System.out.println(x);
    }
    public static long rec(int i, int color, int n, List<List<Integer>> graph, long[][] dp){
        System.out.println(i+" "+color +" "+n);
        if(n == 0)
            return 1;
//        if(dp[n][color]!=-1){
//            return dp[n][color];
//        }

        List<Integer> edges = graph.get(i);
        long sum = 0;
        for(int v: edges){
            // white
            n--;
            if(color == 0) {
                sum += (rec(v, 0, n, graph, dp) % mod);
                sum += (rec(v, 1, n, graph, dp) % mod);
            } else { // black
                sum += (rec(v, 0, n, graph, dp) % mod);
            }
        }
        return dp[n][color] = sum;
    }
}
