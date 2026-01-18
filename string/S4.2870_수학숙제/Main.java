import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    ArrayList<String> nums = new ArrayList<>();
	    for(int i=0;i<N;i++) {
	        char[] list = br.readLine().toCharArray();
	        StringBuilder sb = new StringBuilder("");
	        for(int j=0;j<list.length;j++) {
	            char c = list[j];
	            if(Character.isDigit(c)) {
	                sb.append(c);
	            } else {
	                if(sb.length() > 0) {
	                    nums.add(delete0(sb.toString()));
	                    sb.setLength(0);
	                }
	            }
	        }
	        if(sb.length() > 0) {
	            nums.add(delete0(sb.toString()));
	        }
	    }
	    Collections.sort(nums, (o1, o2) -> {
	        return (o1.length() == o2.length()) 
	                    ? o1.compareTo(o2) 
	                    : o1.length() - o2.length();
	    });
	    StringBuilder ans = new StringBuilder("");
	    for(String n : nums) {
	        ans.append(n).append("\n");
	    }
	    System.out.print(ans.toString());
	}
	
	static String delete0(String s) {
	    int index = 0;
	    while(index < s.length() - 1 && s.charAt(index) == '0') {
	        index++;
	    }
	    return s.substring(index);
	}
	
}
