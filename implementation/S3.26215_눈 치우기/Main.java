import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
	    String[] house = br.readLine().split(" ");
	    for(String h : house) {
	        que.add(Integer.parseInt(h));
	    }
	    
	    int minute = 0;
	    while(que.size() > 0) {
	        if(minute > 1440) {
	            break;
	        }
	        int first = que.poll();
	        if(que.isEmpty()) {
	            minute+=first;
	            break;
	        }
	        int second = que.poll();
	        
	        first--;
	        second--;
	        minute++;
	        
	        if(first > 0) {
	            que.add(first);
	        }
	        if(second > 0) {
	            que.add(second);
	        }
	    }
	    System.out.print((minute > 1440) ? -1 : minute);
	}
}