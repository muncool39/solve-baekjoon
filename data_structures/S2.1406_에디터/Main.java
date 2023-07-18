import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		for(String s : str){
		    left.push(s);
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++){
		    String m = br.readLine();
		    if(m.equals("L")){
		        if(!left.empty()){
		            right.push(left.pop());
		        }
		    }else if(m.equals("D")){
		        if(!right.empty()){
		            left.push(right.pop());
		        }
		    }else if(m.equals("B")){
		        if(!left.empty()){
		            left.pop();
		        }
		    }else{
		        left.push(m.substring(2));
		    }
		}
		StringBuilder sb = new StringBuilder("");
		while(!right.empty()){
		    left.push(right.pop());
		} 
		for(String s : left){
		    sb.append(s);
		}
		System.out.print(sb);
	}
}
