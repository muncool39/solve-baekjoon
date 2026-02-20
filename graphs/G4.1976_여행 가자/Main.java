import java.io.*;

public class Main {
    static int N, K;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = convert(br.readLine());
	    int M = convert(br.readLine());
	    int[] root = new int[N+1];
	    for(int i=1;i<=N;i++) {
	        root[i] = i;
	    }
	    for(int i=1;i<=N;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<N;j++) {
	            if(input[j].equals("1")) {
	                union(root, i, j+1);
	            }
	        }
	    }
	    String[] plan = br.readLine().split(" ");
	    int standard = findRoot(root, convert(plan[0]));
	    for(int i=1;i<M;i++) {
	        int next = convert(plan[i]);
	        if(standard != findRoot(root, next)) {
	            System.out.print("NO");
	            return;
	        }
	    }
	    System.out.print("YES");
	}
	
	private static int findRoot(int[] root, int n) {
	    if(root[n] == n) {
	        return n;
	    }
	    return findRoot(root, root[n]);
	}
	
	private static void union(int[] root, int a, int b) {
	    int ar = findRoot(root, a);
	    int br = findRoot(root, b);
	    
	    if(ar < br) {
	        root[br] = ar;
	    } else {
	        root[ar] = br;
	    }
	}
	
	
	private static int convert(String input) {
	    return Integer.parseInt(input);
	}
}