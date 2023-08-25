import java.io.*;
import java.util.*;

public class Main{
    static int N, count=0;
    static int[][] home;
    static boolean[][] visited;
    static int[] xidx = {-1,1,0,0};
    static int[] yidx = {0,0,-1,1};
    static ArrayList<Integer> dange = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++){
		    String[] arr = br.readLine().split("");
		    for(int j=0;j<N;j++){
		        home[i][j] = Integer.parseInt(arr[j]);
		    }
		}
		for(int i=0;i<N;i++){
		    for(int j=0;j<N;j++){
		        if(!visited[i][j] && home[i][j]==1){
		            dfs(i,j);
		            dange.add(count);
		            count = 0;
		        }
		    }
		}
		StringBuilder sb = new StringBuilder("");
		sb.append(dange.size()).append("\n");
		Collections.sort(dange);
		for(int d : dange){
		    sb.append(d).append("\n");
		}
		System.out.print(sb);
		
	}
	static void dfs(int x,int y){
	    visited[x][y] = true;
	    if(home[x][y]==1){
	        count++;
	        for(int i=0;i<4;i++){
	            int px = x+xidx[i];
	            int py = y+yidx[i];
	            if(px<0 || py<0 || px>=N || py>=N) continue;
	            if(!visited[px][py]) dfs(px,py);
	        }
	    }
	}
}
