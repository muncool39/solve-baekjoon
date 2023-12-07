import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxOneNumber = 0;
		int maxHumanNumber = 0;
		for(int number=1;number<=N;number++){
		    int[] cards = Arrays.stream(br.readLine().split(" "))
		                        .mapToInt(Integer::parseInt).toArray();
		    for(int i=0;i<3;i++){
		        for(int j=i+1;j<4;j++){
		            for(int t=j+1;t<5;t++){
		                int one = (cards[i] + cards[j] + cards[t])%10;
		                if(one >= maxOneNumber){
		                    maxOneNumber = one;
		                    maxHumanNumber = number;
		                }
		            }
		        }
		    }
		}
		System.out.print(maxHumanNumber);
	}
}