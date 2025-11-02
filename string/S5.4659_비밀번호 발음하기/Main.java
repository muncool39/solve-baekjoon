import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    while(true) {
	        String password = br.readLine();
	        if(password.equals("end")) {
	            break;
	        }
	        sb.append(String.format("<%s> ", password));
	        if(case1(password) && case2(password) && case3(password)) {
	            sb.append("is acceptable.");
	        } else {
	            sb.append("is not acceptable.");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
	static String[] moum = {"a", "e", "i", "o", "u"};
	
	private static boolean case1(String pw) {
	    int originLen = pw.length();
	    for(String m : moum) {
	        pw = pw.replace(m, "");
	    }
	    return originLen != pw.length();
	}
	
	private static boolean case2(String pw) {
	    for(int i=3;i<=pw.length();i++) {
	        if(con3(pw.substring(i-3, i))) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private static boolean con3(String pw) {
	    int originLen = pw.length();
	    for(String m : moum) {
	        pw = pw.replace(m, "");
	    }
	    int diff = originLen - pw.length();
	    return (diff == 3 || diff == 0);
	}
	
	private static boolean case3(String pw) {
	    for(int i=0;i<pw.length()-1;i++) {
	        if(pw.charAt(i) == 'e' || pw.charAt(i) == 'o') {
	            continue;
	        }
	        if(pw.charAt(i) == pw.charAt(i+1)) {
	            return false;
	        }
	    }
	    return true;
	}
	
}