import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    br.readLine();
	    String[] num = br.readLine().split(" ");
	    TreeSet<Integer> set = new TreeSet<>();
	    for(String n : num){
	        set.add(Integer.parseInt(n));
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int s : set){
	        sb.append(s).append(" ");
	    }
	    System.out.print(sb);
	}
}