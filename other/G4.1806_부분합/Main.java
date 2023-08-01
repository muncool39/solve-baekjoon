import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		long[] num = new long[N+1];
		for(int i=1;i<=N;i++){
		    num[i]=num[i-1]+Long.parseLong(st.nextToken());
		}
		long sum = 0;
		int front = 0;
		int end = 1;
		int min = N+1;
		while(end<=N){
		    sum = num[end]-num[front];
		    if(sum>=S&&(end-front)<min){
		        min = end-front;
		    }else if(sum<S){
		        end++;
		    }else{
		        front++;
		    }
		}

		if(min==N+1){
		    min=0;
		}
		System.out.print(min);
	}
}