import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int L = Integer.parseInt(input[1]);
	    int[] fruits = Arrays.stream(br.readLine().split(" "))
								.mapToInt(Integer::parseInt).sorted().toArray();
	    for(int f : fruits) {
	        if(L < f) break;
	        L++;
	    }
	    System.out.print(L);
	}
}