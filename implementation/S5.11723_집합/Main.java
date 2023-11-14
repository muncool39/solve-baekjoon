import java.io.*;
import java.util.*;
public class Main{
    static HashSet<Integer> set = new HashSet<>(20);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder("");
		for(int i=0;i<M;i++){
		    String[] order = br.readLine().split(" ");
		    if(order.length>1){
		        result.append(xOrder(order[0], Integer.parseInt(order[1])));
		    }else{
		        set.clear();
		        if(order[0].equals("all")){
		            for(int n=1;n<=20;n++){
		                set.add(n);
		            }
		        }
		    }
		}
		System.out.print(result);
	}
	static String xOrder(String order, int number){
	    boolean isExists = set.contains(number);
	    switch(order){
	        case "add": set.add(number);
	        return "";
	        case "remove": if(isExists) set.remove(number);
	        return "";
	        case "check": if(isExists) return "1\n";
	        return "0\n";
	        case "toggle": if(isExists){
	            set.remove(number);
	            return "";
	        }
	        set.add(number);
	        return "";
	    }
	    return "";
	}
}