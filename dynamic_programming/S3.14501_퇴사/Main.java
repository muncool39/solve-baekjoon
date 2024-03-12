import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[N+1];
		for(int i=0;i<N;i++) {
		    String[] input = br.readLine().split(" ");
		    int T = Integer.parseInt(input[0]);
		    int P = Integer.parseInt(input[1]);
		    for(int next=i+T;next<=N;next++) {
		        sum[next] = (sum[next] < (sum[i] + P))?(sum[i] + P):sum[next];
		    }
		}
		Arrays.sort(sum);
		System.out.print(sum[N]);
	}
}
