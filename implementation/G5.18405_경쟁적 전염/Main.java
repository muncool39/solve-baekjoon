import java.io.*;
import java.util.*;


public class Main {
    static int N, K;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    N = convert(st.nextToken());
	    K = convert(st.nextToken());
	    int[][] tube = new int[N][N];
	    ArrayList<int[]>[] virus = new ArrayList[K+1];
	    for(int i=1;i<=K;i++) {
	        virus[i] = new ArrayList<>();
	    }
	    for(int i=0;i<N;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j=0;j<N;j++) {
	            int p = convert(st.nextToken());
	            if(p > 0) {
	                virus[p].add(new int[]{i, j});
	            }
	            tube[i][j] = p;
	        }
	    }
	    st = new StringTokenizer(br.readLine(), " ");
	    int S = convert(st.nextToken());
	    int X = convert(st.nextToken()) - 1;
	    int Y = convert(st.nextToken()) - 1;
	    System.out.print(findV(tube, virus, S, X, Y));
	}
	
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	private static int findV(
	    int[][] tube, ArrayList[] virus, int S, int X, int Y
    ) {
        int time = 0;
	    while(time < S) {
	        time++;
	        for(int i=1;i<=K;i++) {
	            ArrayList<int[]> vlist = virus[i];
	            ArrayList<int[]> newlist = new ArrayList<>();
	            for(int[] loc : vlist) {
	                for(int[] d : dir) {
	                    int nx = loc[0] + d[0];
	                    int ny = loc[1] + d[1];
	                    if(outOfRange(nx, ny) || tube[nx][ny] > 0){
	                        continue;
	                    }
	                    tube[nx][ny] = i;
	                    newlist.add(new int[]{nx, ny});
	                }
	            }
	            virus[i] = newlist;
	        }
	        if(tube[X][Y] > 0) {
	            return tube[X][Y];
	        }
	    }
	    return tube[X][Y];
	}
	
	private static boolean outOfRange(int x, int y) {
	    return (x >= N || x < 0 || y >= N || y < 0);
	}
	
	
	private static int convert(String input) {
	    return Integer.parseInt(input);
	}
}
