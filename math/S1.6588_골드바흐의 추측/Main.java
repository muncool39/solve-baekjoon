import java.io.*;
public class Main{
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long num[] = new long[1000001];
        num[0]=1;num[1]=1;
	    for(int i=0;i<1000001;i++){
	        if(num[i]==0){
	                for(long j=i+i;j<1000001&&j>1;j+=i)
	                    num[(int)j]=1;
	            }
	    }
	    int n=0;int f=0;
	    while(true){
	        n = Integer.parseInt(br.readLine());
	        if(n==0)
	            break;
	        for(int i=3;i<n;i++){
	            if(num[i]==0){
	                if(num[n-i]==0){
	                    System.out.println(n+" = "+i+" + "+(n-i));
	                    f=1;
	                    break;
	                }
	            }
	        }
	        if(f==0)
	            System.out.println("Goldbach's conjecture is wrong.");
	        f=0;
	    }
	}
}