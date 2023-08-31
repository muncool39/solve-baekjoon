import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] number = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++){
		    number[i] = number[i-1]+Long.parseLong(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for(int k=0;k<M;k++){
		    st = new StringTokenizer(br.readLine()," ");
		    int i = Integer.parseInt(st.nextToken());
		    int j = Integer.parseInt(st.nextToken());
		    sb.append(number[j]-number[i-1]).append("\n");
		}
		System.out.print(sb);
	}
}