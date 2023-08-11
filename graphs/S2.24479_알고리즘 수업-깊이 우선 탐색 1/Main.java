import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] arr;
    static int[] visited;
    static int c = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new int[N+1];
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
		    Collections.sort(arr[i]);
		}
		dfs(R);
		for(int i=1;i<=N;i++){
		    System.out.println(visited[i]);
		}
	}
	
	static void dfs(int i){
	    visited[i] = ++c;
	    for(int v : arr[i]){
	        if(visited[v]>0) continue;
	        dfs(v);
	    }
	}
}