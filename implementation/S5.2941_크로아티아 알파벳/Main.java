import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    int count = 0;
	    for(String alpha : croatia) {
	        count+=((input.length() - input.replace(alpha, "").length())/alpha.length());
	        input = input.replace(alpha, " ");
	    }
	    count+=input.replace(" ","").length();
	    System.out.print(count);
	}
}