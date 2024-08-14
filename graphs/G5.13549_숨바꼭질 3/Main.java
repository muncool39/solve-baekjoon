import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    int result = bfs(N, M);
	    System.out.print(result);
	}
	public static int bfs(int start, int target) {
	    boolean[] visited = new boolean[100001];
	    int[] count = new int[100001];
	    int min = 100000;
	    Queue<Integer> que = new LinkedList<>();
	    que.add(start);
	    visited[start] = true;
	    while(que.size()>0) {
	        int now = que.poll();
	        int nowcount = count[now];
	        if(now == target) {
	            min = (min > nowcount) ? nowcount : min;
	        }
	        int i = 0;
	        for(int next : new int[]{now*2, now-1, now+1}) {
	            i++;
	            if(next>100000 || next<0 || visited[next] || count[next]>=min) {
	                continue;
	            }
	            que.add(next);
	            visited[next] = true;
	            count[next] = (i == 1) ? nowcount : nowcount + 1;
	        }
	    }
	    return min;
	}
}