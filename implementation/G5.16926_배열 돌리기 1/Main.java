import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    int R = Integer.parseInt(input[2]);
	    String[][] arr = new String[N][M];
	    for(int i=0;i<N;i++) {
	        arr[i] = br.readLine().split(" ");
	    }
	    int re = (N<M)?N/2:M/2;
	    String[][] sub = new String[N][M];
	    for(int i=0;i<R;i++) {
	        for(int c=0;c<N;c++) {
	            sub[c] = arr[c].clone();
	        }
	        for(int r=0;r<re;r++) {
	            // R L
	            for(int p=r;p<N-1-r;p++) {
	                arr[p+1][r] = sub[p][r];
	                arr[p][M-1-r] = sub[p+1][M-1-r];
	            }
	            // T B
	            for(int p=r;p<M-1-r;p++) {
	                arr[r][p] = sub[r][p+1];
	                arr[N-1-r][p+1] = sub[N-1-r][p];
	            }
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(String[] marr : arr) {
	        for(String m : marr) {
	            sb.append(m).append(" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	}
}