import java.io.*;
import java.util.*;
public class Main{
    static HashMap<Long,Long> countMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] AB = br.readLine().split(" ");
		long A = Long.parseLong(AB[0]);
		long B = Long.parseLong(AB[1]);
		countMap = new HashMap<Long,Long>();
		countMap.put(A,0L);
		bfs(A, B);
		long answer = (countMap.containsKey(B))?countMap.get(B)+1:-1;
		System.out.print(answer);
	}
	
	static void bfs(long A, long B){
	    Queue<Long> que = new LinkedList<>();
	    que.add(A);
	    while(!que.isEmpty()){
	        long now = que.poll();
	        long nowCount = countMap.get(now);
	        long operation1 = now*2;
	        long operation2 = now*10+1;
	        if(operation1<=B && !countMap.containsKey(operation1)){
	            que.add(operation1);
	            countMap.put(operation1,nowCount+1);
	        }
	        if(operation2<=B && !countMap.containsKey(operation2)){
	            que.add(operation2);
	            countMap.put(operation2,nowCount+1);
	        }
	        if(countMap.containsKey(B)) break;
	    }
	}
}