import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    long[] arr = new long[N];
	    for(int i=0;i<N;i++) {
	        arr[i] = Long.parseLong(br.readLine());
	    }
	    Arrays.sort(arr);
	    int front = 0, back = 1;
	    long min = Long.MAX_VALUE;
	    while(front >= 0 && back < N) {
	        long diff = arr[back] - arr[front];
	        if(diff < M) {
	            back++;
	        } else if (diff > M) {
	            front++;
	            min = (diff < min)? diff : min;
	        } else {
	            min = M;
	            break;
	        }
	    }
	    System.out.print(min);
	}
}