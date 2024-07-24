import java.io.*;
import java.util.*;

public class Main{
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int c=0;c<T;c++) {
	        int ans = 0;
	        int N = Integer.parseInt(br.readLine().split(" ")[0]);
	        long[] A = Arrays.stream(br.readLine().split(" "))
	                            .mapToLong(Long::parseLong).sorted().toArray();
	        long[] B = Arrays.stream(br.readLine().split(" "))
	                            .mapToLong(Long::parseLong).sorted().toArray();
	        int index = 0;
	        for(int i=0;i<B.length;i++) {
	            while(index < N) {
	                if(A[index] > B[i]) {
	                    ans+=(N - index);
	                    break;
	                }
	                index++;
	            }
	        }
	        sb.append(ans).append("\n");
	    }
	    System.out.print(sb);
	}
}