import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] S = br.readLine().split("");
	    String exp = br.readLine();
	    int expSixe = exp.length();
	    
	    StringBuilder sb = new StringBuilder("");
	    for(String s : S) {
	        sb.append(s);
	        if(sb.length()>=expSixe && sb.substring(sb.length()-expSixe).equals(exp)) {
	            sb.delete(sb.length()-expSixe, sb.length());
	        }
	    }
	    
	    System.out.print((sb.length()>0)?sb.toString():"FRULA");
	}
}