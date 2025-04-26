import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    TreeSet<String> set = new TreeSet<>((o1, o2)->{
	        return (o1.length()==o2.length()) ? o1.compareTo(o2) : o1.length() - o2.length();
	    });
	    for(int i=0;i<N;i++) {
	        set.add(br.readLine());
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(String w : set) {
	        sb.append(w).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}
