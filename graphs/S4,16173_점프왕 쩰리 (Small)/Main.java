import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] map;
    static boolean[][] visited;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<N;j++) {
	            map[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    visited = new boolean[N][N];
	    doGame();
	    String ans = (visited[N-1][N-1]) ? "HaruHaru" : "Hing";
	    System.out.print(ans);
	}
	public static void doGame() {
	    int[][] CASE = {{1, 0}, {0, 1}};
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{0, 0, map[0][0]});
	    while(!que.isEmpty()) {
	        int[] now = que.poll();
	        for(int c=0;c<2;c++) {
	            int nextX = now[0] + CASE[c][0] * now[2];
	            int nextY = now[1] + CASE[c][1] * now[2];
	            if(nextX>=N || nextY>=N || visited[nextX][nextY]) continue;
	            visited[nextX][nextY] = true;
	            que.add(new int[]{nextX, nextY, map[nextX][nextY]});
	        }
	    }
	}
}