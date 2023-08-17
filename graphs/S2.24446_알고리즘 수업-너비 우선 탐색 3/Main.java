import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] deep;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		deep = new int[N+1];
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
		bfs(R);
		StringBuilder sb = new StringBuilder("");
		for(int i=1;i<=N;i++){
		    if(i!=R && deep[i]==0) deep[i]=-1;
		    sb.append(deep[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	static void bfs(int i){
	    Queue<Integer> que = new LinkedList<>();
	    que.add(i);
	    visited[i] = true;
	    deep[i] = 0;
	    while(!que.isEmpty()){
	        int u = que.poll();
	        for(int v : arr[u]){
	            if(visited[v])continue;
	            que.add(v);
	            visited[v] = true;
	            deep[v] = deep[u]+1;
	        }
	    }
	}
}