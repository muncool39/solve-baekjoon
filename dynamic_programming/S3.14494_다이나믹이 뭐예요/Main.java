import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int n = Integer.parseInt(input[0]);
	    int m = Integer.parseInt(input[1]);
	    long[][] D = new long[n+1][m+1];
	    D[1][1] = 1;
	    for(int j=2;j<=m;j++) {
	        D[1][j] = (D[0][j] + D[1][j-1] + D[0][j-1])%1000000007;
	    }
	    for(int i=2;i<=n;i++) {
	        for(int j=1;j<=m;j++) {
	            D[i][j] = (D[i-1][j] + D[i][j-1] + D[i-1][j-1])%1000000007;
	        }
	    }
	    System.out.print(D[n][m]);
	}
}