import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] stairs = new int[N+1];
	    for(int i=1;i<=N;i++) {
	        stairs[i] = Integer.parseInt(br.readLine());
	    }
	    if(N == 1) {
	        System.out.print(stairs[1]);
	        return;
	    }
	    int[] w = new int[N+1];
	    w[1] = stairs[1];
	    w[2] = stairs[1] + stairs[2];
	    for(int i=3;i<=N;i++) {
	        w[i] = Math.max(w[i-2], (w[i-3] + stairs[i-1])) + stairs[i];
	    }
	    System.out.print(w[N]);
	}
}