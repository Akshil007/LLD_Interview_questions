import java.util.*;

public class LongestPath {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // weight, value
        int[][] arr = new int[m][2];
        for(int i=0;i<m;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1]  = sc.nextInt();
        }
        System.out.println(getLongest(arr, n, m));
    }
    public static int getLongest(int[][] edges, int n, int m){
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<=n;i++){
            g.add(new ArrayList<>());
        }
        int in[] = new int[n+1];

        for(int i=0;i<m;i++){
            in[edges[i][1]]++;
            g.get(edges[i][0]).add(edges[i][1]);
        }

        int[] dis = new int[n+1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=1;i<=n;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            List<Integer> neigh = g.get(u);
            for(int v:neigh){
                dis[v] = dis[u] + 1;
                in[v]--;
                if(in[v] == 0){
                    q.add(v);
                }
            }
        }

        int max = 0;
        for(int i=1;i<=n;i++){
            max = Math.max(max, dis[i]);
        }
        return max;
    }
}
