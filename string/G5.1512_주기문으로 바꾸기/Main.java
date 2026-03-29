import java.io.*;
import java.util.*;


public class Main {
    static HashMap<Character, Integer> map = new HashMap<>(){{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int M = Integer.parseInt(br.readLine());
	    char[] str = br.readLine().toCharArray();
	    int length = str.length;
	    int minChange = length;
	    for(int p=1;p<=M;p++) {
	        int pchangeSum = 0;
	        for(int i=0;i<p;i++) {
	            int[] count = new int[4];
	            for(int j=i;j<length;j+=p) {
	                count[map.get(str[j])]++;
	            }
	            int all = 0;
	            int max = 0;
	            for(int c=0;c<4;c++) {
	                all+=count[c];
	                max = Math.max(max, count[c]);
	            }
	            int pchange = all - max;
	            pchangeSum+=pchange;
	        }
	        minChange = Math.min(pchangeSum, minChange);
	    }
	    System.out.print(minChange);
	}
}
