import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[][] student = new String[N][];
	    for(int i=0;i<N;i++){
	        student[i] = br.readLine().split(" ");
	    }
	    Arrays.sort(student, new Comparator<String[]>(){
		    public int compare(String[] s1, String[] s2){
		        if(!s1[1].equals(s2[1])) return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
		        else if(!s1[2].equals(s2[2])) return Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]);
		        else if(!s1[3].equals(s2[3])) return Integer.parseInt(s2[3]) - Integer.parseInt(s1[3]);
	            else return s1[0].compareTo(s2[0]);
		    }
		});
		StringBuilder sb = new StringBuilder("");
		for(String[] s : student){
		    sb.append(s[0]).append("\n");
		}
		System.out.print(sb);
	}
}