import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args)throws IOException {
	    long num[] = new long[2000001];
	    num[0]=1;num[1]=1;
	    for(int i=2;i<num.length;i++){
	        if(num[i]==0){
	            for(int j=i+i;j<num.length;j+=i){
	                num[j]=1;
	            }
	        }
	    }
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count=0;
		for(int n=N;n<num.length;n++){
		    if(num[n]==0){
		        String str[]= Integer.toString(n).split("");
		        for(int i=0;i<str.length/2+1;i++){
                    if(str[i].equals(str[str.length-i-1])){
                        count++;
		            }else{
		                count=0;
		                break;
		            }
		        }
            }
            if(count!=0){
                System.out.print(n);
                break;
            }
		}
	}
}