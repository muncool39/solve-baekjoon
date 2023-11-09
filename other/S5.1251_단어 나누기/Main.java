import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> wordList = new ArrayList<>();
		String word = br.readLine();
		int wordSize = word.length();
		for(int firstIndex=1; firstIndex<wordSize-1; firstIndex++) {
			for(int secondIndex=firstIndex+1; secondIndex<wordSize; secondIndex++) {
				StringBuilder firstRange = new StringBuilder(word.substring(0, firstIndex));
				StringBuilder secondRange = new StringBuilder(word.substring(firstIndex, secondIndex));
				StringBuilder lastRange = new StringBuilder(word.substring(secondIndex));
				StringBuilder entireRange = new StringBuilder("");
				entireRange.append(firstRange.reverse());
				entireRange.append(secondRange.reverse());
				entireRange.append(lastRange.reverse());
				wordList.add(entireRange.toString());
			}
		}
		Collections.sort(wordList);
        System.out.println(wordList.get(0));
	}
}