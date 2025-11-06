import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int m = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    HashMap<String, Integer> map = new HashMap<>();
	    for(int i=0;i<m;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<n;i++) {
	        int sum = 0;
	        boolean ing = true;
	        while(ing) {
	            st = new StringTokenizer(br.readLine(), " ");
	            while(st.hasMoreTokens()) {
	                String t = st.nextToken();
	                if(t.equals(".")) {
	                    ing = false;
	                    break;
	                }
	                sum+=map.getOrDefault(t, 0);
	            }
	        }
	        sb.append(sum).append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
}