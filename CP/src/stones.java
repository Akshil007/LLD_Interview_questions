import java.util.Arrays;
import java.util.Scanner;

public class stones {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // weight, value
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        boolean dp[] = new boolean[k+1];
        for(int i=1;i<=k;i++){
            for(int j=0;j<n;j++){
                if(i - arr[j] >=0 ){
                    dp[i] = dp[i] || !dp[i-arr[j]];
                }
            }
        }

        String ans = dp[k] ? "First":"Second";
        System.out.println(ans);
    }

//    public static boolean rec1(int k, int turn, int[] arr, boolean[][] dp){
//        if(k == 0)
//            return false;
//        boolean win = false;
//        for(int i:arr){
//            if(k-i>=0){
//                win = win || !rec(k-i,(turn+1)%2, arr, dp);
//            }
//        }
//        return dp[k][turn] = win;
//    }
//    public static boolean rec2(int k, int turn, int[] arr, boolean[] dp){
//        if(k == 0)
//            return false;
//        boolean win = false;
//        for(int i:arr){
//            if(k-i>=0){
//                win = win || !rec(k-i,(turn+1)%2, arr, dp);
//            }
//        }
//        return dp[k] = win;
//    }
}
