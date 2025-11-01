import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[][] map;
    static int N, M, maxSafe = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    N = Integer.parseInt(info[0]);
	    M = Integer.parseInt(info[1]);
	    map = new int[N][M];
	    for(int i=0;i<N;i++) {
	        String[] pinfo = br.readLine().split(" ");
	        for(int j=0;j<M;j++) {
	            map[i][j] = Integer.parseInt(pinfo[j]);
	            if(map[i][j] == 2) {
	                virus.add(new int[]{i, j});
	            }
	        }
	    }
	    setWall(0, 0);
	    System.out.print(maxSafe);
	}
	
	private static void setWall(int start, int count) {
	    if(count == 3) {
	        explo();
	        return;
	    }
	    for(int i=start;i<N*M;i++) {
	        int x = i / M;
	        int y = i % M;
	        if(map[x][y] == 0) {
	            map[x][y] = 1;
	            setWall(i + 1, count + 1);
	            map[x][y] = 0;
	        }
	    }
	}
	
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	private static void explo() {
	    int[][] cmap = new int[N][M];
	    for(int i=0;i<N;i++) {
	        cmap[i] = map[i].clone();
	    }
	    Queue<int[]> que = new LinkedList<>();
	    for(int i=0;i<virus.size();i++) {
	        que.add(virus.get(i));
	    }
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        for(int i=0;i<4;i++) {
	            int nx = now[0] + dir[i][0];
	            int ny = now[1] + dir[i][1];
	            if(nx<0 || nx>=N || ny<0 || ny>=M || cmap[nx][ny]!=0) {
	                continue;
	            }
	            cmap[nx][ny] = 2;
	            que.add(new int[]{nx, ny});
	        }
	    }
	    int safe = 0;
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<M;j++) {
	            if(cmap[i][j] == 0) {
	                safe++;
	            }
	        }
	    }
	    if(safe > maxSafe) {
	        maxSafe = safe;
	    }
	}
}