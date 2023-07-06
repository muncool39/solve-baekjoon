import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		int top=0;
		arr.add(Integer.parseInt(br.readLine()));
		for(int i=1;i<N;i++){
		    int num = Integer.parseInt(br.readLine());
		    arr.add(num);
		    if(arr.get(top)<=num){
		        top=i;
		    }
		}
		int count=0;
		if(top!=0){
		    while(top!=0){
		        count++;
		        arr.set(0,arr.get(0)+1);
		        arr.set(top,arr.get(top)-1);
		        for(int i=0;i<arr.size();i++){
		            if(arr.get(i)>=arr.get(top)){
		                top=i;
		            }
		        }
		    }
		}
		System.out.print(count);
	}
}
