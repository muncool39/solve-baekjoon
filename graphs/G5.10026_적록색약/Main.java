import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static char[][] RGB;
    static boolean[][] visited;
    static int xidx[] = {-1,1,0,0};
    static int yidx[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    RGB = new char[N][N];
	    visited = new boolean[N][N];
	    for(int i=0;i<N;i++){
	        String pic = br.readLine();
	        for(int j=0;j<N;j++){
	            RGB[i][j] = pic.charAt(j);
	        }
	    }
	    int RGB_count = 0;
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(visited[i][j]) continue;
	            dfs(i, j, RGB[i][j]);
	            RGB_count++;
	        }
	    }
	    visited = new boolean[N][N];
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(RGB[i][j]=='G') RGB[i][j]='R';
	        }
	    }
	    int RB_count = 0;
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(visited[i][j]) continue;
	            dfs(i, j, RGB[i][j]);
	            RB_count++;
	        }
	    }
	    System.out.print(RGB_count+" "+RB_count);
	}
	public static void dfs(int i, int j, char color){
	    for(int m=0;m<4;m++){
	        int nexti = i+xidx[m];
	        int nextj = j+yidx[m];
	        if(nexti<0 || nexti>=N || nextj<0 || nextj>=N) continue;
	        if(!visited[nexti][nextj] && RGB[nexti][nextj]==color){
	            visited[nexti][nextj]=true;
	            dfs(nexti,nextj,color);
	        }
	    }

	}
}