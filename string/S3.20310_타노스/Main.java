import java.io.*;
public class Main{
	public static void main(String[] args)throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String S = br.readLine();
	    StringBuilder sb = new StringBuilder();
	    int cnt0 = S.length() - S.replace("0","").length();
	    int cnt1 = S.length() - S.replace("1","").length();
	    cnt0 = cnt0/2;
	    cnt1 = cnt1/2;
	    int cnt=0;
	    String[] str = S.split("");
	    for(int i=0;i<str.length;i++){
	        if(str[i].equals("1")){
	            str[i]="";
	            cnt++;
	        }
	        if(cnt==cnt1)
	            break;
	    }
	    cnt=0;
	    for(int i=str.length-1;i>=0;i--){
	        if(str[i].equals("0")){
	            str[i]="";
	            cnt++;
	        }
	        if(cnt==cnt0)
	            break;
	    }
	    for(String x : str){
	        sb.append(x);
	    }
	    System.out.print(sb);
	}
}