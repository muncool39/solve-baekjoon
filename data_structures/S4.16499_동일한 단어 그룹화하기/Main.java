import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    HashSet<String> set = new HashSet<>();
	    for(int i=0;i<N;i++) {
	        char[] c = br.readLine().toCharArray();
	        Arrays.sort(c);
	        set.add(String.valueOf(c));
	    }
	    System.out.print(set.size());
	}
}