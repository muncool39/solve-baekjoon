import java.io.*;
import java.util.*;
public class Main{
    static int[] sum;
    static int size, max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = Arrays.stream(br.readLine().split(""))
		                .mapToInt(Integer::parseInt).toArray();
		size = num.length;
		sum = new int[size+1];
		for(int i=1;i<=size;i++){
		    sum[i] = sum[i-1]+ num[i-1];
		}
		for(int i=1;i<=size;i++){
		    check(i);
		}
		System.out.print(max);
	}
	
	static void check(int now){
	    int idx = now-1;
	    int end = now+1;
	    while(end<=size){
	        int right=sum[now]-sum[idx];
	        int left=sum[end]-sum[now];
	        if(right==left){
	            int len = end-idx;
	            if(max<len) max = len;
	        }
	        now+=1;
	        end+=2;
	    }
	}
}