import java.io.*;
import java.util.*;

public class Main{
    static int N, K;
    static int[] visited = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N!=K) bfs();
		System.out.print(visited[K]);
	}
	static void bfs(){
	    Queue<Integer> que = new LinkedList<>();
	    que.add(N);
	    while(visited[K]==0){
	        int now = que.poll();
	        int[] move = new int[] {now-1,now+1,2*now};
	        for(int i=0;i<3;i++){
	            int next = move[i];
	            if(next<0||next>100000||visited[next]>0) continue;
	            visited[next] = visited[now]+1;
	            que.add(next);
	        }
	    }
	}
}