import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];
		String name = br.readLine();
        for(int i=0;i<name.length();i++){
            int idx = name.charAt(i)-'A';
            alpha[idx]++;
        }
        int count=0;
        int mid=-1;
        for(int i=0;i<alpha.length;i++){
            if(alpha[i]%2!=0){
                count++;
                mid=i;
            }
        }
		if(!(count>1)){
		    ArrayList<Character> arr = new ArrayList<>();
		    for(int i=0;i<alpha.length;i++){
		        if(alpha[i]>0){
		            for(int j=0;j<alpha[i]/2;j++){
		                arr.add((char)(i+65));
		            }
		        }
		    }
		    int size = arr.size();
		    for(int i=size-1;i>=0;i--){
		        arr.add(arr.get(i));
		    }
		    if(count==1){
		        arr.add(arr.size()/2,(char)(mid+65));
		    }
		    StringBuilder sb = new StringBuilder("");
		    for(char c : arr){
		        sb.append(c);
		    }
		    System.out.print(sb.toString());
		}else{
		    System.out.print("I'm Sorry Hansoo");
		}
		
	}
}
