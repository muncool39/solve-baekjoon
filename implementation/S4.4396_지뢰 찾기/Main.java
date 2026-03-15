import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] mine, ing;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    mine = new char[n][n];
	    HashSet<int[]> mset = new HashSet<>();
	    for(int i=0;i<n;i++) {
	        mine[i] = br.readLine().toCharArray();
	        for(int j=0;j<n;j++) {
	            if(mine[i][j] == '*') {
	                mset.add(new int[]{i, j});
	            }
	        }
	    }
	    ing = new char[n][n];
	    for(int i=0;i<n;i++) {
	        ing[i] = br.readLine().toCharArray();
	    }
	    char[][] ans = new char[n][n];
	    boolean tread = false;
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            if(ing[i][j] == 'x') {
	                if(mine[i][j] == '*') {
	                    tread = true;
	                } else {
	                    ans[i][j] = countM(i, j);
	                }
	                
	            } else {
	                ans[i][j] = '.';
	            }
	        }
	    }
	    if(tread) {
	        for(int[] m : mset) {
	            ans[m[0]][m[1]] = '*';
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<n;i++) {
	        for(char c : ans[i]) {
	            sb.append(c);
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
	static int[][] dir = {
	    {-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}
	};
	
	static private char countM(int x, int y) {
	    int count = 0;
	    for(int[] d : dir) {
	        int nx = x + d[0];
	        int ny = y + d[1];
	        if(nx < 0 || nx >=n || ny < 0 || ny >= n) {
	            continue;
	        }
	        if(mine[nx][ny] == '*') {
	            count++;
	        }
	    }
	    return Character.forDigit(count, 10);
	}
}