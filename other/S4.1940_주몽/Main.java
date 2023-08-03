import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		long[] number = Arrays.stream(br.readLine().split(" "))
		                        .mapToLong(Long::parseLong).sorted().toArray();
		int front = 0;
		int end = N-1;
		long sum = 0;
		long count = 0;
		while(front<end){
		    sum = number[front]+number[end];
		    if(sum==M){
		        count++;
		    }
		    if(sum>M){
		        end--;
		    }else{
		        front++;
		    }
		}
		System.out.print(count);
	}
}