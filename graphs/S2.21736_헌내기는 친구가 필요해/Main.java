import java.io.*;
import java.util.*;
public class Main{
    static int N, M, count=0;
    static char[][] campus;
    static boolean[][] visited;
    static int[] xidx = {-1,1,0,0};
    static int[] yidx = {0,0,-1,1};
    static Queue<int[]> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		campus = new char[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
		    String str = br.readLine();
		    for(int j=0;j<M;j++){
		        char info = str.charAt(j);
		        if(info=='I'){
		            que.add(new int[]{i,j});
		            visited[i][j] = true;
		        }
		        campus[i][j] = info;
		    }
		}
		bfs();
		if(count==0) System.out.print("TT");
		else System.out.print(count);
	}
	static void bfs(){
	    while(!que.isEmpty()){
	        int[] now = que.poll();
	        int x = now[0];
	        int y = now[1];
	        for(int i=0;i<4;i++){
	            int nx = x+xidx[i];
	            int ny = y+yidx[i];
	            if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;
	            if(campus[nx][ny]!='X') que.add(new int[]{nx,ny});
	            if(campus[nx][ny]=='P') count++;
	            visited[nx][ny] = true;
	        }
	    }
	}
}