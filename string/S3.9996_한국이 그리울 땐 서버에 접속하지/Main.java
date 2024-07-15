import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[] pattern = br.readLine().split("\\*");
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<N;i++) {
	        String fileName = br.readLine();
	        if(fileName.startsWith(pattern[0]) && 
	        fileName.substring(pattern[0].length(), fileName.length()).endsWith(pattern[1])){
	            sb.append("DA").append("\n");
	            continue;
	        }
	        sb.append("NE").append("\n");
	    }
	    System.out.print(sb);
	}
}
