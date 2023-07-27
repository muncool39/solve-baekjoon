import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long sum = 0;
		int[] numbers =  Arrays.stream(br.readLine().split(" "))
		                        .mapToInt(Integer::parseInt).toArray();
		for(int i=0;i<K;i++){
		    sum+=numbers[i];
		}
		long max = sum;
		int start = 0;
		while(K<N){
		    sum+=(numbers[K]-numbers[start]);
		    if(sum>max){
		        max = sum;
		    }
		    K++;
		    start++;
		}
		System.out.print(max);
	}
}