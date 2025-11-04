import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int garo = Integer.parseInt(st.nextToken());
	    int sero = Integer.parseInt(st.nextToken());
	    ArrayList<Integer> gList = new ArrayList<>();
	    ArrayList<Integer> sList = new ArrayList<>();
	    gList.add(0);
	    gList.add(garo);
	    sList.add(0);
	    sList.add(sero);
	    int C = Integer.parseInt(br.readLine());
	    for(int i=0;i<C;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int gs = Integer.parseInt(st.nextToken());
	        int num = Integer.parseInt(st.nextToken());
	        if(gs == 1) {
	            gList.add(num);
	        } else {
	            sList.add(num);
	        }
	    }
	    Collections.sort(gList);
	    Collections.sort(sList);
	    int gMax = 0;
	    for(int i=0;i<gList.size()-1;i++) {
	        gMax = Math.max(gList.get(i+1) - gList.get(i), gMax);
	    }
	    int sMax = 0;
	    for(int i=0;i<sList.size()-1;i++) {
	        sMax = Math.max(sList.get(i+1) - sList.get(i), sMax);
	    }
	    System.out.print(gMax * sMax);
	}
	
}