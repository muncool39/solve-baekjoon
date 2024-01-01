import java.io.*;
import java.util.*;
public class Main{
    static int R, C;
    static boolean[][] visited;
    static String[][] backyard;
    static int[][] next = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    R = Integer.parseInt(input[0]);
	    C = Integer.parseInt(input[1]);
	    visited = new boolean[R][C];
	    backyard = new String[R][];
	    for(int i=0;i<R;i++){
	        backyard[i] = br.readLine().split("");
	    }
	    int O = 0, V = 0;
	    for(int r=0;r<R;r++){
	        for(int c=0;c<C;c++){
	            if(visited[r][c] || backyard[r][c].equals("#")) continue;
	            visited[r][c] = true;
	            int[] counts = bfs(r, c);
	            if(counts[0]>counts[1]) O+=counts[0];
	            else V+=counts[1];
	        }
	    }
	    System.out.print(O+" "+V);
	}
	
	static int[] bfs(int r, int c){
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{r, c});
	    int o = 0, v = 0;
	    while(!que.isEmpty()){
	        int[] now = que.poll();
	        if(backyard[now[0]][now[1]].equals("o")) o++;
	        else if(backyard[now[0]][now[1]].equals("v")) v++;
	        for(int i=0;i<4;i++){
	            int nr = now[0] + next[i][0];
	            int nc = now[1] + next[i][1];
	            if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
	            if(visited[nr][nc] || backyard[nr][nc].equals("#")) continue;
	            que.add(new int[]{nr, nc});
	            visited[nr][nc] = true;
	        }
	    }
	    return new int[]{o, v};
	}
}