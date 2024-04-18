import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    HashMap<String, Double> subjectMap = new HashMap<>() {{
	        put("A+", 4.5);
            put("A0", 4.0);
            put("B+", 3.5);
            put("B0", 3.0);
            put("C+", 2.5);
            put("C0", 2.0);
            put("D+", 1.5);
            put("D0", 1.0);
            put("F", 0.0);
	    }};
	    double creditTotalSum = 0;
	    double creditSum = 0;
	    for(int i=0;i<20;i++) {
	        String[] input = br.readLine().split(" ");
	        if(input[2].equals("P")) continue;
	        double credit = Double.parseDouble(input[1]);
	        creditTotalSum+=credit;
	        creditSum+= credit*subjectMap.get(input[2]);
	    }
	    System.out.print(String.format("%.6f", creditSum/creditTotalSum));
	}
}