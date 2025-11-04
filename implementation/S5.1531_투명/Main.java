import java.io.*;
import java.util.*;

public class Main {
    static int[][] pic;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    pic = new int[101][101];
	    for(int i=0;i<N;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        int d = Integer.parseInt(st.nextToken());
	        count(a, b, c, d);
	    }
	    int see = 0;
	    for(int i=1;i<=100;i++) {
	        for(int j=1;j<=100;j++) {
	            if(pic[i][j] > M) {
	                see++;
	            }
	        }
	    }
	    System.out.print(see);
	}
	
	private static void count(int a, int b, int c, int d) {
	    for(int i=a;i<=c;i++) {
	        for(int j=b;j<=d;j++) {
	            pic[i][j]++;
	        }
	    }
	}
	
}