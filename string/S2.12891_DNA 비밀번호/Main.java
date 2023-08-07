import java.io.*;
import java.util.*;

public class Main{
    
    static char[] DNA;
    static int[] ACGT = new int[4];
    static int[] ACGTcount = new int[4];
    static int count = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] DNA = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++){
		    ACGT[i] = Integer.parseInt(st.nextToken());
		    if(ACGT[i]==0) count++;
		}
		int result = 0;
	    for(int i=0;i<P;i++){
	        add(DNA[i]);
	    }
		if(count==4) result++;
		for(int i=P;i<S;i++){
		    delete(DNA[i-P]);
		    add(DNA[i]);
		    if(count==4) result++;
		}
		System.out.print(result);
	}
	
	private static void add(char c){
	    if(c=='A'){
	        ACGTcount[0]++;
	        if(ACGTcount[0]==ACGT[0]) count++;
	    }else if(c=='C'){
	        ACGTcount[1]++;
	        if(ACGTcount[1]==ACGT[1]) count++;
	    }else if(c=='G'){
	        ACGTcount[2]++;
	        if(ACGTcount[2]==ACGT[2]) count++;
	    }else if(c=='T'){
	        ACGTcount[3]++;
	        if(ACGTcount[3]==ACGT[3]) count++;
	    }
	}
	
	private static void delete(char c){
	    if(c=='A'){
	        if(ACGTcount[0]==ACGT[0]) count--;
	        ACGTcount[0]--;
	    }else if(c=='C'){
            if(ACGTcount[1]==ACGT[1]) count--;
            ACGTcount[1]--;
	    }else if(c=='G'){
            if(ACGTcount[2]==ACGT[2]) count--;
            ACGTcount[2]--;
	    }else if(c=='T'){
            if(ACGTcount[3]==ACGT[3]) count--;
            ACGTcount[3]--;
	    }
	}
}