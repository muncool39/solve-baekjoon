import java.io.*;
import java.util.*;
public class Main{
    static int count = 0;
    static int M, N;
    static int[] xidx = {-1,1,0,0};
    static int[] yidx = {0,0,-1,1};
    static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		for(int i=0;i<K;i++){
		    st = new StringTokenizer(br.readLine()," ");
		    int x1 = Integer.parseInt(st.nextToken());
		    int y1 = Integer.parseInt(st.nextToken());
		    int x2 = Integer.parseInt(st.nextToken());
		    int y2 = Integer.parseInt(st.nextToken());
		    for(int x=x1;x<x2;x++){
		        for(int y=y1;y<y2;y++){
		            visited[y][x] = true;
		        }
		    }
		}
		ArrayList<Integer> area = new ArrayList<>();
		for(int i=0;i<M;i++){
		    for(int j=0;j<N;j++){
		        if(visited[i][j]) continue;
		        dfs(i,j);
		        area.add(count);
		        count=0;
		    }
		}
		Collections.sort(area);
		StringBuilder sb = new StringBuilder("");
		sb.append(area.size()).append("\n");
		for(int as : area){
		    sb.append(as).append(" ");
		}
		System.out.print(sb);
	}
	
	static void dfs(int y, int x){
	    count++;
	    visited[y][x] = true;
	    for(int i=0;i<4;i++){
	        int nextY = y+yidx[i];
	        int nextX = x+xidx[i];
	        if(nextY>=M||nextY<0||nextX<0||nextX>=N) continue;
	        if(!visited[nextY][nextX]) dfs(nextY,nextX);
	    }
	}
}