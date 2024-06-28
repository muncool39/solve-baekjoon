import java.io.*;
import java.util.*;

public class Main {
    static int[] visited = new int[100001];
    static int[] root = new int[100001];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int K = Integer.parseInt(input[1]);
	    if(N!=K) findRoot(N, K);
	    
	    StringBuilder sb = new StringBuilder("");
	    sb.append(N);
	    if(N!=K) sb.append(getRoot(K, N));
        
	    System.out.println(visited[K]);
	    System.out.print(sb.toString());
	}
	public static String getRoot(int last, int start) {
	    StringBuilder sb = new StringBuilder("");
	    while(last!=start) {
	        sb.insert(0, last).insert(0, " ");
	        last = root[last];
	    }
	    return sb.toString();
	}
	
	public static void findRoot(int start, int target) {
	    Queue<Integer> que = new LinkedList<>();
	    que.add(start);
	    while(!que.isEmpty()) {
	        int now = que.poll();
	        int[] next = new int[]{now-1, now+1, now*2};
	        for(int n : next) {
	            if(n<0 || n>100000 || visited[n]>0) continue;
	            visited[n] = visited[now]+1;
	            root[n] = now;
	            if(n==target) {
	                que.clear();
	                break;
	            }
	            que.add(n);
	        }
	    }
	}
}