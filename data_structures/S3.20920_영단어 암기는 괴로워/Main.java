import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> counts = new HashMap<>(100000);
		for(int i=0;i<N;i++){
		    String word = br.readLine();
		    if(word.length()<M) continue;
		    if(counts.containsKey(word)){
		        int c = counts.get(word);
		        counts.replace(word,++c);
		        continue;
		    } 
		    counts.putIfAbsent(word, 1);
		}
		List<String> keywords = new ArrayList<>(counts.keySet());
		keywords.sort(new Comparator<String>(){
		    public int compare(String w1, String w2){
		        if(counts.get(w1)==counts.get(w2)){
	                if(w1.length()==w2.length()) return w1.compareTo(w2);
	                else return w2.length() - w1.length();
	            }
	            else return counts.get(w2).compareTo(counts.get(w1));
		    }
		});
		StringBuilder sb = new StringBuilder("");
		for(String word : keywords){
		    sb.append(word).append("\n");
		}
		System.out.print(sb);
	}
}