import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int count = 0;
	    for(int i=0;i<N;i++) {
	        if(isGoodWord(br.readLine().split(""))) {
	            count++;
	        }
	    }
	    System.out.print(count);
	}
	public static boolean isGoodWord(String[] wordArray) {
	    Stack<String> stack = new Stack<>();
	    for(String word : wordArray) {
	        if(stack.isEmpty()) {
	            stack.push(word);
	        } else if(stack.peek().equals(word)) {
	            stack.pop();
	        } else {
	            stack.push(word);
	        }
	    }
	    return stack.isEmpty();
	}
}