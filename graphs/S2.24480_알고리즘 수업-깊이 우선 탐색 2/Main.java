import java.io.*;
import java.util.*;

public class Main{
    static int[] visited;
    static ArrayList<Integer>[] arr;
    static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new int[N+1];
		arr = new ArrayList[N+1];
		for(int i=1;i<=N;i++){
		    arr[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine()," ");
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    arr[u].add(v);
		    arr[v].add(u);
		}
		for(int i=1;i<=N;i++){
		    Collections.sort(arr[i], Collections.reverseOrder());
		}
		dfs(R);
		StringBuilder sb = new StringBuilder("");
		for(int i=1;i<=N;i++){
		    sb.append(visited[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int i){
	    visited[i] = ++count;
	    for(int v : arr[i]){
	        if(visited[v]>0) continue;
	        dfs(v);
	    }
	}
}