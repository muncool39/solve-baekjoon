import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue<Long> que = new PriorityQueue<>(Collections.reverseOrder());
	    StringBuilder sb = new StringBuilder("");
	    int N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++) {
	        long x = Long.parseLong(br.readLine());
	        if(x==0) {
	            sb.append((que.isEmpty())?0:que.poll()).append("\n");
	            continue;
	        }
	        que.add(x);
	    }
	    System.out.print(sb);
	}
}