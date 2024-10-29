import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    for(int i=0;i<T;i++){
	        HashSet<String> set = new HashSet<>();
	        br.readLine();
	        for(String n : br.readLine().split(" ")) {
	            set.add(n);
	        }
	        StringBuilder sb = new StringBuilder("");
	        br.readLine();
	        for(String m : br.readLine().split(" ")) {
	            sb.append((set.contains(m))?1:0).append("\n");
	        }
	        System.out.print(sb.toString());
	    }
	}
}