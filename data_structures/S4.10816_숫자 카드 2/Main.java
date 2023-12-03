import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> cardCount = new HashMap<>(N);
		String[] numberCards = br.readLine().split(" ");
		for(String numberCard : numberCards){
		    if(cardCount.containsKey(numberCard)){
		        cardCount.replace(numberCard, cardCount.get(numberCard)+1);
		        continue;
		    }
		    cardCount.put(numberCard, 1);
		}
		br.readLine();
		String[] findCards = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder("");
		for(String findCard : findCards){
		    sb.append(cardCount.getOrDefault(findCard, 0)).append(" ");
		}
		System.out.print(sb);
	}
}