import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] number = new long[N+1];
		st = new StringTokenizer(br.readLine()," ");
		number[1] = Long.parseLong(st.nextToken());
		for(int i=2;i<=N;i++){
		    number[i] = Long.parseLong(st.nextToken())+number[i-1];
		}
		StringBuilder sb = new StringBuilder("");
		for(int p=0;p<M;p++){
		    st = new StringTokenizer(br.readLine()," ");
		    int i = Integer.parseInt(st.nextToken())-1;
		    int j = Integer.parseInt(st.nextToken());
		    sb.append(number[j]-number[i]).append("\n");
		}
		System.out.print(sb);
	}
}
