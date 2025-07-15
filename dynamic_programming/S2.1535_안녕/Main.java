import java.io.*;
import java.util.*;

public class Main {
    static int[] L, J;
    static int N, maxJoy = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    L = new int[N];
	    J = new int[N];
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<N;i++) {
	        L[i] = Integer.parseInt(st.nextToken());
	    }
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<N;i++) {
	        J[i] = Integer.parseInt(st.nextToken());
	    }
	    findMax(100, 0, 0);
	    System.out.print(maxJoy);
	}
	
	private static void findMax(int hp, int joy, int index) {
	    if(hp <= 0) {
	        return;
	    }
	    if(index == N) {
	        maxJoy = Math.max(maxJoy, joy);
	        return;
	    }
	    findMax(hp, joy, index + 1);
	    findMax(hp - L[index], joy + J[index], index + 1);
	}
}