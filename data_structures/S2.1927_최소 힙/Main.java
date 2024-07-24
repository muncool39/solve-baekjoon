import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue<Long> que = new PriorityQueue<>();
	    int N = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<N;i++) {
	        long num = Long.parseLong(br.readLine());
	        if(num==0) {
	            sb.append((que.isEmpty())?0:que.poll()).append("\n");
	            continue;
	        }
	        que.add(num);
	    }
	    System.out.print(sb);
	}
}