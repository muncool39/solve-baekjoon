import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] btn = new int[N+2];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
		    btn[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for(int i=0;i<N;i++){
		    if(btn[i]==1){
		        count++;
		        btn[i+1] = (btn[i+1]==0) ? 1 : 0;
		        btn[i+2] = (btn[i+2]==0) ? 1 : 0;
		    }
		}
		System.out.print(count);
	}
}