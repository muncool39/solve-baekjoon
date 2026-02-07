import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    int n = Integer.parseInt(info[0]);
	    int k = Integer.parseInt(info[1]);
	    ArrayList<Integer>[] list = new ArrayList[n];
	    for(int i=0;i<n;i++) {
	        list[i] = new ArrayList<>();
	    }
	    for(int i=0;i<n-1;i++) {
	        String[] edge = br.readLine().split(" ");
	        int p = Integer.parseInt(edge[0]);
	        int c = Integer.parseInt(edge[1]);
	        list[p].add(c);
	    }
	    int[] values = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	    int target = 0;
	    for(int i=0;i<n;i++) {
	        if(values[i] == k) {
	            target = i;
	            break;
	        }
	    }
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{0, 0});
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        if(now[0] == target) {
	            System.out.print(now[1]);
	            break;
	        }
	        for(int c : list[now[0]]) {
	            que.add(new int[]{c, (now[1]+1)});
	        }
	    }
	}
}