import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<T;i++) {
	        String[] input = br.readLine().split(" ");
	        int N = Integer.parseInt(input[0]);
	        int M = Integer.parseInt(input[1]);
	        for(int j=0;j<M;j++) {
	            br.readLine();
	        }
	        sb.append(N-1).append("\n");
	    }
	    System.out.print(sb);
	}
}