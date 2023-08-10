import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] computer;
    static boolean[] visited;
    static int count = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		computer = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++){
		    computer[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<S;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int com1 = Integer.parseInt(st.nextToken());
		    int com2 = Integer.parseInt(st.nextToken());
		    computer[com1].add(com2);
		    computer[com2].add(com1);
		}
		dfs(1);
		System.out.print(count);
	}
	
	static void dfs(int i){
	    if(visited[i]) return;
	    visited[i] = true;
	    count++;
	    for(int c : computer[i]){
	        if(!visited[c])dfs(c);
	    }
	}
}