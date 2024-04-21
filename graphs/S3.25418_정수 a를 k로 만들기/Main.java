import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int A = Integer.parseInt(input[0]);
	    int K = Integer.parseInt(input[1]);
	    int count = bfs(A, K, new int[K+1]);
	    System.out.print(count);
	    
	}
	static int bfs(int a, int k, int[] count) {
	    Queue<Integer> que = new LinkedList<>();
	    que.add(a);
	    while(!que.isEmpty()) {
	        int index = que.poll();
	        int operation1 = index+1;
	        if(operation1 > k) continue;
	        if(count[operation1] == 0 || count[operation1] > count[index]+1) {
	            que.add(operation1);
	            count[operation1] = count[index] + 1;
	        }
	        int operation2 = index*2;
	        if(operation2 > k) continue;
	        if(count[operation2] == 0 || count[operation2] > count[index]+1) {
	            que.add(operation2);
	            count[operation2] = count[index] + 1;
	        }
	    }
	    return count[k];
	}
}