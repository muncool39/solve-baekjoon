import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[][] time = new int[N][2];
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        time[i][0] = Integer.parseInt(input[0]);
	        time[i][1] = Integer.parseInt(input[1]);
	    }
	    Arrays.sort(time, (o1, o2) -> {
	        return (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0];
	    });
	    PriorityQueue<Integer> que = new PriorityQueue<>();
	    que.add(time[0][1]);
	    for(int i=1;i<N;i++) {
	        if(que.peek() <= time[i][0]) {
	            que.poll();
	        }
	        que.add(time[i][1]);
	    }
	    System.out.print(que.size());
	}
	
}