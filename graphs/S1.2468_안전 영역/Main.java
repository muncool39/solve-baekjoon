import java.io.*;
import java.util.*;
public class Main{
    static int N, rain = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] xidx = {-1,1,0,0};
    static int[] yidx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++){
		    String[] height = br.readLine().split(" ");
		    for(int j=0;j<N;j++){
		        arr[i][j] = Integer.parseInt(height[j]);
		    }
		}
		int max = 0;
		int count = 0;
		while(rain<=100){
		    count = 0;
		    visited = new boolean[N][N];
		    for(int x=0;x<N;x++){
		        for(int y=0;y<N;y++){
		            if(!visited[x][y] && arr[x][y]>rain){
		                bfs(x,y);
		                count++;
		            }
		        }
		    }
		    if(count>max) max = count;
		    rain++;
		}
		System.out.print(max);
	}
	
	static void bfs(int x,int y){
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[] {x,y});
	    visited[x][y] = true;
	    while(!que.isEmpty()){
	        int[] now = que.poll();
	        for(int i=0;i<4;i++){
	            int dx = now[0]+xidx[i];
	            int dy = now[1]+yidx[i];
	            if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
	            if(!visited[dx][dy]){
	                visited[dx][dy] = true;
	                if(arr[dx][dy]>rain){
	                    que.add(new int[] {dx,dy});
	                }
	            }
	        }
	    }
	}
}