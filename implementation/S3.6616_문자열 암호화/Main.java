import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    while(true){
	        int N = Integer.parseInt(br.readLine());
	        if(N==0) break;
	        String[] message = br.readLine().replace(" ","").toUpperCase().split("");
	        String[] ciphertext = new String[message.length];
	        if(message.length<=N || N==1){
	            sb.append(String.join("",message)).append("\n");
	            continue;
	        }
	        int index = 0;
	        int start = 0;
	        for(String t : message){
	            ciphertext[index] = t;
	            index+=N;
	            if(index>=message.length) index = ++start;
	        }
	        sb.append(String.join("",ciphertext)).append("\n");
	    }
	    System.out.print(sb);
	}
}