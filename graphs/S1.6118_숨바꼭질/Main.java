import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    ArrayList<Integer>[] link = new ArrayList[N+1];
	    for(int i=1;i<=N;i++) {
	        link[i] = new ArrayList<>();
	    }
	    for(int i=0;i<M;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int A = Integer.parseInt(st.nextToken());
	        int B = Integer.parseInt(st.nextToken());
	        link[A].add(B);
	        link[B].add(A);
	    }
	    int[] dis = new int[N+1];
	    int max = 0;
	    Queue<Integer> que = new LinkedList<>();
	    que.add(1);
	    while(que.size()>0) {
	        int now = que.poll();
	        for(int i=0;i<link[now].size();i++) {
	            int next = link[now].get(i);
	            if(next==1) continue;
	            if(dis[next]<1) {
	                que.add(next);
	                dis[next] = dis[now] + 1;
	            }
	        }
	        max = dis[now];
	    }
	    StringBuilder sb = new StringBuilder("");
	    boolean first = true;
	    int count = 0;
	    for(int i=2;i<=N;i++) {
	        if(dis[i]==max) {
	            count++;
	            if(first){
	                sb.append(i).append(" ").append(max).append(" ");
	                first = false;
	            }
	        }
	    }
	    System.out.print(sb.append(count).toString());
	}
}