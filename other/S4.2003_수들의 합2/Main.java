import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] A = new long[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++){
		    long x = Long.parseLong(st.nextToken());
		    A[i] = x+A[i-1];
		}
		int a = 0, b = 1;
		int count = 0;
		while(b<=N){
		    long Ax = A[b]-A[a];
		    if(Ax==M) count++;
		    if(Ax<=M) b++;
		    else if(Ax>M) a++;
		    if(a>=b) b++;
		}
		System.out.print(count);
	}
}