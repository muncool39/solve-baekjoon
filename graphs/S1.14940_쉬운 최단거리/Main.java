import java.io.*;
import java.util.*;
public class Main{
    static int n, m;
    static int[][] map;
    static int[][] visited;
    static int[] nidx = {-1,1,0,0};
    static int[] midx = {0,0,-1,1};
    static Queue<int[]> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		for(int i=0;i<n;i++){
		    st = new StringTokenizer(br.readLine()," ");
		    for(int j=0;j<m;j++){
		        int p = Integer.parseInt(st.nextToken());
		        if(p==2) que.add(new int[]{i,j});
		        map[i][j] = p;
		    }
		}
		bfs();
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<n;i++){
		    for(int j=0;j<m;j++){
		        int dst = (visited[i][j]==0&&map[i][j]==1)?-1:visited[i][j];
		        sb.append(dst).append(" ");
		    }
		    sb.append("\n");
		}
		System.out.print(sb);
	}
	static void bfs(){
	    while(!que.isEmpty()){
	        int[] now = que.poll();
	        for(int i=0;i<4;i++){
	            int nn = now[0]+nidx[i];
	            int nm = now[1]+midx[i];
	            if(nn<0||nm<0||nn>=n||nm>=m) continue;
	            if(map[nn][nm]==1 && visited[nn][nm]==0){
	                que.add(new int[]{nn,nm});
	                visited[nn][nm]=visited[now[0]][now[1]]+1;
	            }
	        }
	    }
	}
}