import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    StringTokenizer st;
	    String str = br.readLine();
	    while(str != null && !str.equals("")) {
	        st = new StringTokenizer(str, " ");
	        String s = st.nextToken();
	        String t = st.nextToken();
	        sb.append(isCombine(s.toCharArray(), t.toCharArray())).append("\n");
	        str = br.readLine();
	    }
	    System.out.print(sb.toString());
	}
	
	private static String isCombine(char[] s, char[] t) {
	    int start = 0;
	    for(char c : s) {
	        boolean ex = false;
	        for(int i=start;i<t.length;i++) {
	            if(t[i] == c) {
	                start = i+1;
	                ex = true;
	                break;
	            }
	        }
	        if(!ex) {
	            return "No";
	        }
	    }
	    return "Yes";
	}
}