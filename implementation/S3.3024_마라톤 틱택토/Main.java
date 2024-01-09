import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[][] board = new String[N][];
	    String answer = "ongoing";
	    for(int x=0;x<N;x++){
	        board[x] = br.readLine().split("");
	    }
	    int[][] nexts = {{0,1},{1,0},{1,1},{1,-1}};
	    for(int x=0;x<N;x++){
	        for(int y=0;y<N;y++){
	            String now = board[x][y];
	            if(now.equals(".")) continue;
	            for(int i=0;i<4;i++){
	                int nextx = x + nexts[i][0];
	                int nexty = y + nexts[i][1];
	                int lastx = x + nexts[i][0]*2;
	                int lasty = y + nexts[i][1]*2;
	                if(lastx>=N || lasty>=N || lasty<0) continue;
	                if(now.equals(board[nextx][nexty])&&now.equals(board[lastx][lasty])){
	                    answer = now;
	                    break;
	                }
	            }
	            if(answer.length()<2) break;
	        }
	    }
	    System.out.print(answer);
	}
}