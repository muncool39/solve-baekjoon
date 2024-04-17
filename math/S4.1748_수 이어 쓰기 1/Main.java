import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long N = Long.parseLong(br.readLine());
	    long c = 0;
	    long f = 10;
	    long plus = 1;
	    for(long i=1;i<=N;i++) {
	        if(i==f) {
	            plus+=1;
	            f*=10;
	        }
	        c+=plus;
	    }
	    System.out.print(c);
	}
}