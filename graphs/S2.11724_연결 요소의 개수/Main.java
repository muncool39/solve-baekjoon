import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
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
		int count = 0;
		for(int i=1;i<=N;i++){
		    if(!visited[i]){
		        DFS(i);
		        count++;
		    }
		}
		System.out.print(count);
	}
	static void DFS(int i){
	    if(visited[i]) return;
	    visited[i] = true;
	    for(int v : arr[i]){
	        if(!visited[v]) DFS(v);
	    }
	}
}