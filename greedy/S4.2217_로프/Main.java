import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    long[] ropes = new long[N];
	    for(int i=0;i<N;i++){
	        ropes[i] = Long.parseLong(br.readLine());
	    }
	    Arrays.sort(ropes);
	    for(int i=0;i<N;i++){
	        ropes[i]*=(N-i);
	    }
	    System.out.print(Arrays.stream(ropes).max().getAsLong());
	}
}