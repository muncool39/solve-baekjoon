import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int num = 0;
		while(true){
		    String str = br.readLine();
		    if(str.contains("-")){
		        break;
		    }
		    int count = 0;
		    Stack<Character> stack = new Stack<>();
		    for(int i=0;i<str.length();i++){
		        char c = str.charAt(i);
		        if(c=='{'){
		            stack.add(c);
		        }else{
		            if(stack.isEmpty()){
		                count++;
		                stack.add('{');
		            }else{
		                stack.pop();
		            }
		        }
		    }
		    count+=stack.size()/2;
		    num++;
		    sb.append(num).append(". ").append(count).append("\n");
		}
		System.out.print(sb);
	}
}
