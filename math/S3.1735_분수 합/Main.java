import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int a1 = Integer.parseInt(st.nextToken());
	    int a2 = Integer.parseInt(st.nextToken());
	    int ag = gcd(a1, a2);
	    a1 /= ag;
	    a2 /= ag;
	    st = new StringTokenizer(br.readLine());
	    int b1 = Integer.parseInt(st.nextToken());
	    int b2 = Integer.parseInt(st.nextToken());
	    int bg = gcd(b1, b2);
	    b1 /= bg;
	    b2 /= bg;
	    int abg = gcd(a2, b2);
	    int sum1 = a1*(b2/abg) + b1*(a2/abg);
	    int sum2 = a2*(b2/abg);
	    int lastabg = gcd(sum1, sum2);
	    System.out.print(sum1/lastabg+" "+sum2/lastabg);
	}
	static int gcd(int p, int q){
	    if (q == 0) return p;
	    return gcd(q, p%q);
	}
}