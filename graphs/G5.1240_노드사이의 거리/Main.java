import java.io.*;
import java.util.*;

public class Main{
    static int[][] tree;
    static boolean[] visited;
    static int N, M, ans;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    tree = new int[N+1][N+1];
	    for(int i=1;i<N;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int n1 = Integer.parseInt(st.nextToken());
	        int n2 = Integer.parseInt(st.nextToken());
	        int dt = Integer.parseInt(st.nextToken());
	        tree[n1][n2] = dt;
	        tree[n2][n1] = dt;
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<M;i++) {
	        visited = new boolean[N+1];
	        ans = 0;
	        st = new StringTokenizer(br.readLine(), " ");
	        int n1 = Integer.parseInt(st.nextToken());
	        int n2 = Integer.parseInt(st.nextToken());
	        if(tree[n1][n2] > 0) {
	            sb.append(tree[n1][n2]).append("\n");
	            continue;
	        }
	        visited[n1] = true;
	        dfs(n1, n2, 0);
	        sb.append(ans).append("\n");
	    }
	    System.out.print(sb);
	}
	public static void dfs(int n1, int target, int sum) {
	    if(n1 == target) ans = sum;
	    if(ans > 0) return;
	    for(int n2=1;n2<=N;n2++) {
	        if(tree[n1][n2] < 1 || visited[n2]) continue;
	        visited[n2] = true;
	        dfs(n2, target, sum + tree[n1][n2]);
	    }
	}
}