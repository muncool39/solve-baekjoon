import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    HashMap<String, String> map = new HashMap<>() {{
	        put("(", ")");
	        put(")", "(");
	        put("[", "]");
	        put("]", "[");
	    }};
	    while(true) {
	        String str = br.readLine();
	        if(str.equals(".")) break;
	        Stack<String> stack = new Stack<>();
	        for(String s : str.split("")) {
	            if(map.getOrDefault(s, "n").equals("n")) continue;
	            if(!stack.isEmpty() && stack.peek().equals(map.get(s))) {
	                stack.pop();
	                continue;
	            }
	            stack.add(s);
	            if(s.equals(")") || s.equals("]")) {
	                break;
	            }
	        }
	        sb.append((stack.isEmpty())?"yes\n":"no\n");
	    }
	    System.out.print(sb.toString());
	}
}