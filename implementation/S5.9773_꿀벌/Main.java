import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] works = {"Re","Pt","Cc","Ea","Tb","Cm","Ex"};
		StringBuilder sb = new StringBuilder("");
		String str = br.readLine();
		while (str!=null){
		    sb.append(str.replace(" ",""));
		    str = br.readLine();
		}
		StringBuilder ans = new StringBuilder("");
		String doworks = sb.toString().replace("\n","");
		double total = doworks.length()/2;
		for(String w : works){
		    int count = (doworks.length() - doworks.replace(w,"").length())/2;
		    ans.append(w).append(" ").append(count).append(" ");
		    String ratio = String.format("%.2f", (double)count/total);
		    ans.append(ratio).append("\n");
		}
		ans.append("Total ").append((int)total).append(" 1.00");
		System.out.println(ans);
    }
}