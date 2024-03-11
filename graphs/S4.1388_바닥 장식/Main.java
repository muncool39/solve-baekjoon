import java.io.*;

public class Main{
    static String[][] floor;
    static boolean[][] visited;
    static int N, M;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        floor = new String[N][M];
        for(int n=0;n<N;n++) {
            String[] line = br.readLine().split("");
            for(int m=0;m<M;m++) {
                floor[n][m] = line[m];
            }
        }
        visited = new boolean[N][M];
        int count = 0;
        for(int n=0;n<N;n++) {
            for(int m=0;m<M;m++) {
                if(visited[n][m]) continue;
                count++;
                visited[n][m] = true;
                if(floor[n][m].equals("-")) dfsM(n, m+1);
                if(floor[n][m].equals("|")) dfsN(n+1, m);
            }
        }
	    System.out.print(count);
	}
	
	static void dfsM(int n, int next) {
	    if(next>=M || visited[n][next] || !floor[n][next].equals("-")) return;
	    visited[n][next] = true;
	    dfsM(n, next+1);
	    return;
	}
	
	static void dfsN(int next, int m) {
	    if(next>=N || visited[next][m] || !floor[next][m].equals("|")) return;
	    visited[next][m] = true;
	    dfsN(next+1, m);
	    return;
	}
}