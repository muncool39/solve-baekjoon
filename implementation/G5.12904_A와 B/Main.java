import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());
		int sl = S.length();
		int tl = T.length();
		while(tl>sl){
		    if(T.charAt(tl-1)=='B'){
		        T.deleteCharAt(tl-1);
		        T.reverse();
		    }else{
		        T.deleteCharAt(tl-1);
		    }
		    tl--;
		}
		int ans = (S.equals(T.toString()))?1:0;
		System.out.print(ans);
	}
		
}