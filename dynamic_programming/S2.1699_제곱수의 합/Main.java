import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] count = new int[N+1];
	    for(int i=0;i<=N;i++) {
	        count[i] = i;
	        for(int j=2;j*j<=i;j++) {
	            count[i] = (count[i-(j*j)]+1 < count[i])?count[i-(j*j)]+1:count[i];
	        }
	    }
	    System.out.print(count[N]);
	}
}