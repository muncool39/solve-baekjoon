import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N+1];
		long[] countArr = new long[M];
		long count = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++){
		    arr[i] = (arr[i-1] + Long.parseLong(st.nextToken()))%M;
		    if(arr[i]==0){
		        count++;
		    }
		    countArr[(int)arr[i]]++;
		}
	    for(int i=0;i<M;i++){
	        if(countArr[i]>1){
                count += (countArr[i]*(countArr[i]-1))/2;
            }
	    }
	    System.out.print(count);
	}
}