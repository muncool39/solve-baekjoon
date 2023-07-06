import java.io.*;
public class Main{
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long arr[] =new long[500001];
	    arr[1]=1;
	    int n = 0;int count = 0;
	    while(true){
	        n = Integer.parseInt(br.readLine());
	        if(n==0)
	            break;
	        for(int i=2;i<=2*n;i++){
	            if(arr[i]==0){
	                for(int j=i+i;j<=2*n;j+=i){
	                    arr[j]=1;
	                }
	            }
	        }
	        for(int i=n+1;i<=2*n;i++){
	            if(arr[i]==0)
	                count++;
	        }
	        System.out.println(count);
	        count=0;
	    }
	}
}