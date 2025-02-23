import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[][] arr = new int[N+1][M+1];
	    for(int i=1;i<=N;i++){
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j=1;j<=M;j++) {
	            arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j-1];
	        }
	    }
	    int K = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int k=0;k<K;k++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int i = Integer.parseInt(st.nextToken());
	        int j = Integer.parseInt(st.nextToken());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        int sum = 0;
	        for(int n=i;n<=x;n++) {
	            sum+=(arr[n][y] - arr[n][j-1]);
	        }
	        sb.append(sum).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}