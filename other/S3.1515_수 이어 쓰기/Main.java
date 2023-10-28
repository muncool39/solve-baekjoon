import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder num = new StringBuilder(br.readLine());
		int N = 0;
		while(num.length()>0){
		    N++;
		    String[] nextNum = String.valueOf(N).split("");
		    for(String next : nextNum){
		        String firstNum = num.substring(0,1).replace(next,"");
		        num.replace(0,1,firstNum);
		        if(num.length()<=0) break;
		    }
		}
		System.out.print(N);
	}
}