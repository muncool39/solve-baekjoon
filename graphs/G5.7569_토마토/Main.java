import java.io.*;
import java.util.*;

public class Main{
    static int M, N, H;
    static int[] zidx = {-1,1,0,0,0,0};
    static int[] xidx = {0,0,-1,1,0,0};
    static int[] yidx = {0,0,0,0,-1,1};
    static int[][][] tomato;
    static int[][][] visited;
    static Queue<int[]> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];
		visited = new int[H][N][M];
		for(int z=0;z<H;z++){
		    for(int x=0;x<N;x++){
		        st = new StringTokenizer(br.readLine()," ");
		        for(int y=0;y<M;y++){
		            int status = Integer.parseInt(st.nextToken());
		            if(status==1) que.add(new int[] {z,x,y});
		            tomato[z][x][y] = status;
		        }
		    }
		}
		bfs();
		int max = 0;
		for(int z=0;z<H;z++){
		    for(int x=0;x<N;x++){
		        for(int y=0;y<M;y++){
		            if(visited[z][x][y]==0&&tomato[z][x][y]==0){
		                max=-1; break;
		            }else if(visited[z][x][y]>max) max=visited[z][x][y];
		        }
		        if(max<0) break;
		    }
		    if(max<0) break;
		}
		System.out.print(max);
	}
	static void bfs(){
	    while(!que.isEmpty()){
	        int[] now = que.poll();
	        int z = now[0];
	        int x = now[1];
	        int y = now[2];
	        for(int i=0;i<6;i++){
	            int nz = z+zidx[i];
	            int nx = x+xidx[i];
	            int ny = y+yidx[i];
	            if(nz<0||nx<0||ny<0||nz>=H||nx>=N||ny>=M) continue;
	            if(visited[nz][nx][ny]==0&&tomato[nz][nx][ny]==0){
	                visited[nz][nx][ny] = visited[z][x][y]+1;
	                que.add(new int[] {nz,nx,ny});
	            }
	        }
	    }
	}
}