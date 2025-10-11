import java.io.*;

public class Main {
    static boolean[][] coin;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    
	    coin = new boolean[N][M];
	    for(int i=0;i<N;i++) {
	        String[] c = br.readLine().split("");
	        for(int j=0;j<M;j++) {
	            coin[i][j] = c[j].equals("0");
	        }
	    }
	    
	    int ln = N - 1;
	    int lm = M - 1;
	    int count = 0;
	    while(ln >= 0 && lm >= 0) {
	        for(int i=ln;i>=0;i--) {
	            if(!coin[i][lm]) {
	                count++;
	                change(i, lm);
	            }
	        }
	        for(int i=lm;i>=0;i--) {
	            if(!coin[ln][i]) {
	                count++;
	                change(ln, i);
	            }
	        }
	        
	        if(ln == 0 && lm == 0) {
	            break;
	        }
	        
	        ln -= (ln > 0) ? 1 : 0;
	        lm -= (lm > 0) ? 1 : 0;
	    }
	    
	    System.out.print(count);
	    
	}
	
	public static void change(int n, int m) {
	    for(int i=0;i<=n;i++) {
	        for(int j=0;j<=m;j++) {
	            coin[i][j] = !coin[i][j];
	        }
	    }
	}
}
