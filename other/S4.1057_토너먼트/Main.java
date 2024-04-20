import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
		int jimin = Integer.parseInt(input[1]);
		int hansu = Integer.parseInt(input[2]);
		int round = 0;
		while(jimin!=hansu) {
		    jimin -= jimin/2;
		    hansu -= hansu/2;
		    round++;
		}
		System.out.print(round);
	}
}
