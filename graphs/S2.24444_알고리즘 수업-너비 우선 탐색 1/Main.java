import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] counted;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		counted = new int[N+1];
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
		bfs(R);
		for(int i=1;i<=N;i++){
		    System.out.println(counted[i]);
		}
	}
	
	static void bfs(int i){
	    Queue<Integer> que = new LinkedList<Integer>();
	    que.add(i);
	    int count = 1;
	    visited[i] = true;
	    while(!que.isEmpty()){
	        int q = que.poll();
	        counted[q] = count;
	        for(int v : arr[q]){
	            if(visited[v]) continue;
	            que.add(v);
	            visited[v] = true;
	        }
	        count++;
	    }
	}
	
}