import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    Set<String> set = new HashSet<>();
	    set.add("ChongChong");
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        if(set.contains(input[0]) || set.contains(input[1])) {
	            set.add(input[0]);
	            set.add(input[1]);
	        }
	    }
	    System.out.print(set.size());
	}
}