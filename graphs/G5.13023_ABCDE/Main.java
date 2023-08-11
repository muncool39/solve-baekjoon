import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] human;
    static boolean[] visited;
    static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		human = new ArrayList[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++){
		    human[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    human[a].add(b);
		    human[b].add(a);
		}
		for(int i=0;i<N;i++){
		    if(!visited[i]){
		        dfs(i,1);
		    }
		    if(result==1) break;
		}
		System.out.print(result);
	}
	static void dfs(int i, int d){
	    if(d==5 || result==1){
	        result = 1;
	        return;
	    }
	    visited[i] = true;
	    for(int v : human[i]){
	        if(visited[v]) continue;
	        dfs(v, d+1);
	    }
	    visited[i] = false;
	}
}