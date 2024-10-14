import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    input = input.replace("XXXX", "AAAA");
	    input = input.replace("XX", "BB");
	    if(input.length() - input.replace("X", "").length() > 0) {
	        input = "-1";
	    }
	    System.out.print(input);
	}
}