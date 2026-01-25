import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int L = Integer.parseInt(br.readLine());
	    int[] S = Arrays.stream(br.readLine().split(" "))
	                    .mapToInt(Integer::parseInt)
	                    .sorted()
	                    .toArray();
	    int n = Integer.parseInt(br.readLine());
	    int min = 0;
	    int max = S[L-1];
	    for(int i=0;i<L;i++) {
	        if(S[i] >= n) {
	            max = S[i];
	            if(i > 0) {
	                min = S[i-1];
	            }
	            break;
	        }
	    }
	    if(min == n || max == n) {
	        System.out.print(0);
	        return;
	    }
	    int count = 0;
	    for(int i=min+1;i<=n;i++) {
	        for(int j=n;j<max;j++) {
	            count++;
	        }
	    }
	    count--;
	    System.out.print(count);
	}
}