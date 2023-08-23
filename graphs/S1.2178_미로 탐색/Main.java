import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] miro, deep;
    static boolean[][] visited;
    static int[] xidx = {-1,1,0,0};
    static int[] yidx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];
		deep = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
		    String[] num = br.readLine().split("");
		    for(int j=0;j<M;j++){
		        miro[i][j] = Integer.parseInt(num[j]);
		    }
		}
		bfs(0,0);
		System.out.print(deep[N-1][M-1]);
	}
	
	static void bfs(int i, int j){
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[] {i,j});
	    visited[i][j] = true;
	    deep[i][j] = 1;
	    while(!visited[N-1][M-1]){
	        int now[] = que.poll();
	        for(int k=0;k<4;k++){
	            int x = now[0]+xidx[k];
	            int y = now[1]+yidx[k];
	            if(x<0 || y<0 || x>=N || y>=M) continue;
	            if(!visited[x][y] && miro[x][y]!=0){
	                visited[x][y] = true;
	                deep[x][y] = deep[now[0]][now[1]]+1;
	                que.add(new int[] {x,y});
	            }
	        }
	    }
	}
}