import java.io.*;
import java.util.*;

public class Main{
    static int N, K, count = 0;
    static int[] kits;
    static boolean[] visited;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    N = Integer.parseInt(input[0]);
	    K = Integer.parseInt(input[1]);
	    visited = new boolean[N];
	    kits = Arrays.stream(br.readLine().split(" "))
	                    .mapToInt(Integer::parseInt)
	                    .toArray();
	    findCount(500, 0);
	    System.out.print(count);
	}
	
	public static void findCount(int amount, int day) {
	    if(amount < 500) return;
	    if(day == N) {
	        count++;
	        return;
	    }
	    for(int i=0;i<N;i++) {
	        if(visited[i]) continue;
	        visited[i] = true;
	        findCount(amount+kits[i]-K, day+1);
	        visited[i] = false;
	    }
	}
}