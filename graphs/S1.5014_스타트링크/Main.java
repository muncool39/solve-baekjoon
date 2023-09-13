import java.io.*;
import java.util.*;
public class Main{
    static int F, G;
    static int[] button, visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		button = new int[]{U,D*-1};
		visited = new int[F+1];
		if(S!=G) BFS(S);
		String ans = (S!=G&&visited[G]==0)?"use the stairs":Integer.toString(visited[G]);
		System.out.print(ans);
	}
	static void BFS(int S){
	    Queue<Integer> que = new LinkedList<>();
	    que.add(S);
	    while(!que.isEmpty()){
	        int now = que.poll();
	        for(int b : button){
	            if(b==0)continue;
	            int nextF = now + b;
	            if(nextF<1||nextF>F||visited[nextF]>0)continue;
	            visited[nextF] = visited[now]+1;
	            if(nextF==G) return;
	            que.add(nextF);
	        }
	    }
	}
}