import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int C = Integer.parseInt(st.nextToken());
	    HashMap<Integer, Integer> fr = new HashMap<>();
	    ArrayList<Integer> number = new ArrayList<>();
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<N;i++) {
	        int num = Integer.parseInt(st.nextToken());
	        if(fr.containsKey(num)) {
	            fr.replace(num, fr.get(num) + 1);
	        } else {
	            fr.put(num, 1);
	            number.add(num);
	        }
	    }
	    
	    number.sort((o1, o2)->{
	        int o1f = fr.get(o1);
	        int o2f = fr.get(o2);
	        return (o1f != o2f) ? o2f - o1f : 0;
	    });
	    
	    StringBuilder sb = new StringBuilder("");
	    for(int n : number) {
	        for(int i=0;i<fr.get(n);i++) {
	            sb.append(n).append(" ");
	        }
	    }
	    System.out.print(sb.toString());
	}
}