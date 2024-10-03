import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<T;i++) {
	        String[] ps = br.readLine().split("");
	        int n = Integer.parseInt(br.readLine());
	        LinkedList<String> xs = convertToList(br.readLine(), n);
	        boolean reverse = false, error = false;
	        for(String p : ps) {
	            if(p.equals("R")) {
	                reverse = !reverse;
	                continue;
	            } else if(n<1) {
	                error = true;
	                break;
	            } else if(reverse) xs.removeLast();
	            else xs.removeFirst();
	            n--;
	        }
	        sb.append((error)?"error":convertToString(xs, reverse)).append("\n");
	    }
	    System.out.println(sb.toString());
	}
	public static LinkedList<String> convertToList(String input, int n){
	    LinkedList<String> list = new LinkedList<>();
	    if(n==0) return list;
	    input = input.substring(1, input.length()-1);
	    for(String num : input.split(",")) {
	        list.addLast(num);
	    }
	    return list;
	}
	public static String convertToString(LinkedList<String> list, boolean reverse) {
	    StringBuilder sb = new StringBuilder("[");
	    while(!list.isEmpty()) {
	        if(reverse) sb.append(list.removeLast());
	        else sb.append(list.removeFirst());
	        if(!list.isEmpty()) sb.append(",");
	    }
	    sb.append("]");
	    return sb.toString();
	}
}