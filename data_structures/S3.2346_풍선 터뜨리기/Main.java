import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    Deque<int[]> deque = new ArrayDeque<>();
	    String[] nums = br.readLine().split(" ");
	    for(int i=1;i<=N;i++) {
	        deque.add(new int[]{i, Integer.parseInt(nums[i-1])});
	    }
	    StringBuilder sb = new StringBuilder("");
	    sb.append("1 ");
	    int next = deque.poll()[1];
	    while(deque.size() > 0) {
	        int[] now;
	        if(next > 0) {
	            for(int i=1;i<next;i++) {
	                deque.add(deque.poll());
	            }
	            now = deque.poll();
	        } else {
	            for(int i=1;i<-next;i++) {
	                deque.addFirst(deque.pollLast());
	            }
	            now = deque.pollLast();
	        }
	        sb.append(now[0]).append(" ");
	        next = now[1];
	    }
	    System.out.print(sb.toString());
	}
}
