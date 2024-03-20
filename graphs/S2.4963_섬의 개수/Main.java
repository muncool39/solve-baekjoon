import java.io.*;

public class Main{
    static int w, h;
    static String[][] map;
    static boolean[][] visited;
    static int[][] next = {
        {-1,-1},{-1,0},{-1,1},{0, 1},
        {1,-1},{0,-1},{1,1},{1, 0}
    };
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder ans = new StringBuilder("");
	    while(true) {
	        String[] input = br.readLine().split(" ");
	        if(input[0].equals("0") && input[1].equals("0")) break;
	        w = Integer.parseInt(input[0]);
	        h = Integer.parseInt(input[1]);
	        map = new String[h][w];
	        for(int i=0;i<h;i++) {
	            map[i] = br.readLine().split(" ");
	        }
	        int count = 0;
	        visited = new boolean[h][w];
	        for(int i=0;i<h;i++) {
	            for(int j=0;j<w;j++) {
	                if(visited[i][j] || map[i][j].equals("0")) continue;
	                count++;
	                dfs(i, j);
	            }
	        }
	        ans.append(count).append("\n");
	    }
	    System.out.print(ans);
	}
	static void dfs(int nowH, int nowW) {
	    visited[nowH][nowW] = true;
	    for(int i=0;i<8;i++) {
	        int nextH = nowH + next[i][0];
	        int nextW = nowW + next[i][1];
	        if(nextW<0 || nextW>=w || nextH<0 || nextH>=h) continue;
	        if(visited[nextH][nextW] || map[nextH][nextW].equals("0")) continue;
	        dfs(nextH, nextW);
	    }
	}
}