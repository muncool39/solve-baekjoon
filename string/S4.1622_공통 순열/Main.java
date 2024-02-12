import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    String alphabets = "abcdefghijklmnopqrstuvwxyz";
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder answer = new StringBuilder("");
	    while(true) {
	        StringBuilder sb = new StringBuilder("");
	        String a = br.readLine();
	        String b = br.readLine();
	        for(String alphabet : alphabets.split("")) {
	            int aCount = getCount(a, alphabet);
	            int bCount = getCount(b, alphabet);
	            int commonCount = Math.min(aCount, bCount);
	            for(int i=0;i<commonCount;i++) {
	                sb.append(alphabet);
	            }
	        }
	        answer.append(sb.toString()).append("\n");
	        if(!br.ready()) break;
	    }
	    System.out.print(answer);
	}
	private static int getCount(String m, String alphabet) {
	    return m.length() - m.replace(alphabet, "").length();
	}
}