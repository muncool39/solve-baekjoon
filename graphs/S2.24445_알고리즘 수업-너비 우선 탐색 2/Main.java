import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new ArrayList[N+1];
		count = new int[N+1];
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
		    Collections.sort(arr[i],Collections.reverseOrder());
		}
		bfs(R);
		StringBuilder sb = new StringBuilder("");
		for(int i=1;i<=N;i++){
		    sb.append(count[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	static void bfs(int i){
	    Queue<Integer> que = new LinkedList<>();
	    que.add(i);
	    visited[i] = true;
	    int c = 0;
	    while(!que.isEmpty()){
	        int q = que.poll();
	        count[q] = ++c;
	        for(int v : arr[q]){
	            if(visited[v]) continue;
	            que.add(v);
	            visited[v] = true;
	        }
	    }
	}
}