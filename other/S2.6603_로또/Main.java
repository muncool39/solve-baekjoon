import java.io.*;

public class Main{
    static int k;
    static String[] S;
    static StringBuilder lottos = new StringBuilder("");
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while(true) {
	        S = br.readLine().split(" ");
	        if(S[0].equals("0")) break;
	        k = Integer.parseInt(S[0]);
	        findLotto(1, 0);
	        lottos.append("\n");
	    }
	    System.out.print(lottos);
	}
	static String[] lotto = new String[6];
	static void findLotto(int next, int deep) {
	    if(deep == 6) {
	        lottos.append(String.join(" ", lotto)).append("\n");
	        return;
	    }
	    for(int i=next;i<=k;i++) {
	        lotto[deep] = S[i];
	        findLotto(i+1, deep+1);
	    }
	}
}