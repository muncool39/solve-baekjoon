import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		String answer = "";
		if(Integer.toString(number, 3).contains("2") || number==0){
		    answer = "NO";
		}else {
		    answer = "YES";
		}
		System.out.print(answer);
	}
}