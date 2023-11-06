import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int[][] G;
    static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		visited = new int[N][N];
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    for(int j=0;j<N;j++){
		        G[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		for(int i=0;i<N;i++){
		    bfs(i);
		}
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<N;i++){
		    for(int j=0;j<N;j++){
		        sb.append(visited[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		System.out.print(sb);
	}
    static void bfs(int i){
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        while(!que.isEmpty()){
            int now = que.poll();
            for(int j=0;j<N;j++){
                if(visited[i][j]==0&&G[now][j]==1){
                    visited[i][j]=1;
                    que.add(j);
                }
            }
        }
    }
}