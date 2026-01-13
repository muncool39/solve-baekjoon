import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int tc=0;tc<T;tc++) {
			br.readLine();
	        String[] input = br.readLine().split(" ");
	        PriorityQueue<Long> que = new PriorityQueue<>();
	        for(String f : input) {
	            que.add(Long.parseLong(f));
	        }
	        long sum = 0;
	        while(que.size() > 1) {
	            long f1 = que.poll();
	            long f2 = que.poll();
	            long fpf = f1 + f2;
	            sum+=fpf;
	            que.add(fpf);
	        }
	        sb.append(sum).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}