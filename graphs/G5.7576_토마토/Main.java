import java.io.*;
import java.util.*;

public class Main{
    static int M, N;
    static int[][] tomato, visited;
    static int[] xidx = {-1,1,0,0};
    static int[] yidx = {0,0,-1,1};
    static Queue<int[]> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		visited = new int[N][M];
		for(int x=0;x<N;x++){
		    st = new StringTokenizer(br.readLine()," ");
		    for(int y=0;y<M;y++){
		        int status = Integer.parseInt(st.nextToken());
		        if(status==1){
		            que.add(new int[] {x,y});
		            visited[x][y] = 1;
		        } 
		        tomato[x][y] = status;
		    }
		}
		bfs();
		int max = 1;
        for(int x=0;x<N;x++){
            for(int y=0;y<M;y++){
                int v = visited[x][y];
                if(v==0&&tomato[x][y]==0){
                    max=0;
                    break;
                }else if(max<v) max=v;
            }
            if(max<1)break;
        }
		System.out.print(max-1);
	}
	static void bfs(){
	    while(!que.isEmpty()){
	        int[] now = que.poll();
	        for(int i=0;i<4;i++){
	            int px = now[0]+xidx[i];
	            int py = now[1]+yidx[i];
	            if(px<0||py<0||px>=N||py>=M) continue;
	            if(visited[px][py]==0&&tomato[px][py]==0){
	                que.add(new int[] {px,py});
	                visited[px][py] = visited[now[0]][now[1]]+1;
	            }
	        }
	    }
	}
}