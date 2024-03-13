import java.io.*;

public class Main{
    static int[] xd = {1,-1,0,0};
    static int[] yd = {0,0,1,-1};
    static int move = Integer.MAX_VALUE;
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for(int i=0;i<5;i++) {
	        String[] line = br.readLine().split(" ");
	        for(int j=0;j<5;j++) {
	            board[i][j] = Integer.parseInt(line[j]);
	        }
	    }
	    String[] input = br.readLine().split(" ");
	    int r = Integer.parseInt(input[0]);
	    int c = Integer.parseInt(input[1]);
	    visited[r][c] = true;
	    dfs(r, c, 0, 0);
	    
	    System.out.print((move==Integer.MAX_VALUE)?-1:move);
	}
	
	static void dfs(int r, int c, int deep, int count) {
	    if(count==3) {
	        move = (move > deep)?deep:move;
	        return;
	    }
	    for(int i=0;i<4;i++) {
	        int nextR = r + xd[i];
	        int nextC = c + yd[i];
	        if(nextR<0 || nextR>=5 || nextC<0 || nextC>=5 || visited[nextR][nextC]) continue;
	        if(board[nextR][nextC]==-1) continue;
	        visited[nextR][nextC] = true;
	        if(board[nextR][nextC]==1) dfs(nextR, nextC, deep+1, count+1);
	        else dfs(nextR, nextC, deep+1, count);
	        visited[nextR][nextC] = false;
	    }
	}
}