import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T>0) {
		    String cryingSounds = " " + br.readLine();
		    while(true){
		        String[] animalCrying = br.readLine().split(" ");
		        if(animalCrying.length > 3) break;
		        cryingSounds = cryingSounds.replace(" " + animalCrying[2], "");
		    }
		    String foxCryingSound = cryingSounds.strip();
		    System.out.println(foxCryingSound);
		    T--;
		}
	}
}