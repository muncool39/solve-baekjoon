import java.io.*;
import java.util.*;
public class Main{
    static int M, N, K;
    static int[][] farm;
    static boolean[][] visited;
    static int[] xidx = {-1,1,0,0};
    static int[] yidx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<T;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    M = Integer.parseInt(st.nextToken());
		    N = Integer.parseInt(st.nextToken());
		    K = Integer.parseInt(st.nextToken());
		    farm = new int[M][N];
		    visited = new boolean[M][N];
		    for(int j=0;j<K;j++){
		        st = new StringTokenizer(br.readLine()," ");
		        int x = Integer.parseInt(st.nextToken());
		        int y = Integer.parseInt(st.nextToken());
		        farm[x][y] = 1;
		    }
		    int count = 0;
		    for(int x=0;x<M;x++){
		        for(int y=0;y<N;y++){
		            if(!visited[x][y] && farm[x][y]==1){
		                count++;
		                dfs(x,y);
		            }
		        }
		    }
		    sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
	static void dfs(int x, int y){
	    visited[x][y] = true;
	    if(farm[x][y]!=1) return;
	    for(int i=0;i<4;i++){
	       int px = x + xidx[i];
	       int py = y + yidx[i];
	       if(px<0 || py<0 || px>=M || py>=N) continue;
	       if(!visited[px][py]) dfs(px,py);
	   }
	}
}