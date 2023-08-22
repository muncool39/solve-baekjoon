import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] arr;
    static long[] visited;
    static long[] deep;
    static long sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new long[N+1];
		deep = new long[N+1];
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
		bfs(R,1);
		System.out.print(sum);
	}
	
	static void bfs(int i, long count){
	    Queue<Integer> que = new LinkedList<>();
	    que.add(i);
	    deep[i] = 0;
	    visited[i] = count;
	    while(!que.isEmpty()){
	        int u = que.poll();
	        sum+= deep[u]*visited[u];
	        for(int v : arr[u]){
	            if(visited[v]>0) continue;
	            que.add(v);
	            visited[v] = ++count;
	            deep[v] = deep[u]+1;
	        }
	    }
	}
}