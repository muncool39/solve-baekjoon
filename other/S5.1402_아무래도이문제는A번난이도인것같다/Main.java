import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<T;i++) {
	        br.readLine();
	        sb.append("yes\n");
	    }
	    System.out.print(sb.toString());
	}
}