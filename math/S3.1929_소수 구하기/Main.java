import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int M = Integer.parseInt(input[0]);
	    int N = Integer.parseInt(input[1]);
	    boolean[] notsosu = new boolean[N+1];
	    StringBuilder sb = new StringBuilder("");
	    for(int i=2;i<=N;i++) {
	        if(notsosu[i]) continue;
	        if(i>=M) sb.append(i).append("\n");
	        for(int j=i*2;j<=N;j+=i) {
	            notsosu[j] = true;
	        }
	    }
	    System.out.print(sb);
	}
}