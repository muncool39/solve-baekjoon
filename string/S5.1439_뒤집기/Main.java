import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] S = br.readLine().split("");
		long min = 0;
		boolean check = false;
		String s = S[0];
		for(long i=0;i<S.length;i++){
		    if(!(s.equals(S[(int)i]))){
		        min++;
		        if(check){
		            min--;
		            check = false;
		        }else{
		            check = true;
		        }
		        s = S[(int)i];
		    }
		}
		System.out.print(min);
	}
}
