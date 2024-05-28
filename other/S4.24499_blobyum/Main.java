import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int K = Integer.parseInt(input[0]);
	    int N = Integer.parseInt(input[1]);
	    long[] appleSum = new long[K+1];
	    String[] apple = br.readLine().split(" ");
	    for(int i=0;i<K;i++) {
	        appleSum[i+1] = appleSum[i] + Long.parseLong(apple[i]);
	    }
	    long sum = 0;
	    long max = 0;
	    for(int start=0;start<K;start++) {
	        int end = start + N;
	        if(end<=K) {
	            sum = appleSum[end] - appleSum[start];
	        } else {
	            sum = appleSum[K] - appleSum[start] + appleSum[end%K];
	        }
	        max = (max < sum) ? sum : max;
	        sum = 0;
	    }
	    System.out.print(max);
	}
}
