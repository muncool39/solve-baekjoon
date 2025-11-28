import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    String[] student = br.readLine().split(" ");
	    HashMap<String, Integer> map = new HashMap<>();
	    for(String s : student) {
	        map.put(s, 0);
	    }
	    for(int i=0;i<n;i++) {
	        String[] love = br.readLine().split(" ");
	        for(String s : love) {
	            map.replace(s, map.get(s) + 1);
	        }
	    }
	    Arrays.sort(student, (o1, o2) -> {
	        if(map.get(o1) == map.get(o2)) {
	            return o1.compareTo(o2);
	        }
	        return map.get(o2) - map.get(o1);
	    });
	    StringBuilder sb = new StringBuilder("");
	    for(String s : student) {
	        sb.append(s).append(" ").append(map.get(s)).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}