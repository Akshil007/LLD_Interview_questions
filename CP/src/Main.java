import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(jump(n, k, arr));
    }

    static int jump(int n, int k, int arr[]){
        int dp[] = new int[n+1];
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j = i-1; j >= 0 && j >= i - k; j--) {
                min = Math.min(min, dp[j+1] + Math.abs(arr[i] - arr[j]));
            }
            dp[i+1] = min;
        }
        return dp[n];
    }
}