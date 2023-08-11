import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder D = new StringBuilder("");
    static StringBuilder B = new StringBuilder("");
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++){
		    arr[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    arr[a].add(b);
		    arr[b].add(a);
		}
		for(int i=1;i<=N;i++){
		    Collections.sort(arr[i]);
		}
        dfs(V);
        visited = new boolean[N+1];
        bfs(V);
		System.out.println(D);
		System.out.print(B);
	}

    static void dfs(int i){
        D.append(i).append(" ");
        visited[i] = true;
        for(int v : arr[i]){
            if(visited[v]) continue;
            dfs(v);
        }
    }
    
    static void bfs(int i){
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(i);
        visited[i] = true;
        while(!Q.isEmpty()){
            int p = Q.poll();
            B.append(p).append(" ");
            for(int v : arr[p]){
                if(visited[v]) continue;
                Q.add(v);
                visited[v] = true;
            }
        }
    }
}