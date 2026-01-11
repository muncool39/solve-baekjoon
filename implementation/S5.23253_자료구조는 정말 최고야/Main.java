import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int M = Integer.parseInt(br.readLine().split(" ")[1]);
	    boolean Possible = true;
	    for(int i=0;i<M;i++) {
	        int k = Integer.parseInt(br.readLine());
	        int[] book = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	       for(int j=1;j<k;j++) {
	           if(book[j] > book[j-1]) {
	               Possible = false;
	               break;
	           }
	       }
	    }
	    System.out.print((Possible) ? "Yes" : "No");
	}
}