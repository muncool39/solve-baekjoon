import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int testCase = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    while(testCase>0){
	        testCase--;
	        HashMap<String, Integer> typeCounts = new HashMap<>();
	        int n = Integer.parseInt(br.readLine());
	        for(int i=0;i<n;i++){
	            String clothesType = br.readLine().split(" ")[1];
	            if(typeCounts.containsKey(clothesType)){
	                typeCounts.replace(clothesType, typeCounts.get(clothesType)+1);
	                continue;
	            }
	            typeCounts.put(clothesType, 1);
	        }
	        long clothingCase = 1;
	        for(String clothesType : typeCounts.keySet()){
	            clothingCase*=typeCounts.get(clothesType)+1;
	        }
	        sb.append(clothingCase-1).append("\n");
	    }
	    System.out.print(sb);
	}
}
