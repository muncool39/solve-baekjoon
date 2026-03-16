import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static boolean[][] ice;
    static HashMap<int[], Integer> iceberg = new HashMap<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    N = convertToInt(input[0]);
	    M = convertToInt(input[1]);
	    ice = new boolean[N][M];
	    for(int i=0;i<N;i++) {
	        String[] minput = br.readLine().split(" ");
	        for(int j=0;j<M;j++) {
	            int p = convertToInt(minput[j]);
	            if(p > 0) {
	                iceberg.put(new int[]{i, j}, p);
	                ice[i][j] = true;
	            }
	        }
	    }
	    int time = 0;
	    boolean mt = false;
	    while(iceberg.size() > 0) {
	        if(isSeparated()) {
	            mt = true;
	            break;
	        }
	        time++;
	        ArrayList<int[]> delete = new ArrayList<>();
	        for(int[] ib : iceberg.keySet()) {
	            int x = ib[0];
	            int y = ib[1];
	            int b = melt(x, y, iceberg.get(ib));
	            if(b == 0) {
	                delete.add(ib);
	            } else {
	                iceberg.replace(ib, b);
	            }
	        }
	        for(int[] d : delete) {
	            ice[d[0]][d[1]] = false;
	            iceberg.remove(d);
	        }
	    }
	    System.out.print(mt ? time : 0);
	}
	
	static boolean[][] checked;
	
	private static boolean isSeparated() {
	    checked = new boolean[N][M];
	    int lump = 0;
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<M;j++) {
	            if(!checked[i][j] && ice[i][j]) {
	                if(lump > 0) {
	                    return true;
	                }
	                DFS(i, j);
	                lump++;
	            }
	        }
	    }
	    return false;
	}
	
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	private static int melt(int x, int y, int now) {
	    for(int[] d : dir) {
	        int nx = x + d[0];
	        int ny = y + d[1];
	        if(nx < 0 || nx >= N || ny < 0 || ny >= M || ice[nx][ny]) {
	            continue;
	        }
	        now--;
	    }
	    return now < 0 ? 0 : now;
	}
	
	private static void DFS(int x, int y) {
	    checked[x][y] = true;
	    for(int[] d : dir) {
	        int nx = x + d[0];
	        int ny = y + d[1];
	        if(nx < 0 || nx >= N || ny < 0 || ny >= M || checked[nx][ny] || !ice[nx][ny]) {
	            continue;
	        }
	        DFS(nx, ny);
	    }
	}
	
	private static int convertToInt(String str) {
	    return Integer.parseInt(str);
	}
}