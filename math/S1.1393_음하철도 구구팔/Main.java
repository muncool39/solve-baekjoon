import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] station = br.readLine().split(" ");
	    int xs = Integer.parseInt(station[0]);
	    int ys = Integer.parseInt(station[1]);
	    String[] train = br.readLine().split(" ");
	    int xe = Integer.parseInt(train[0]);
	    int ye = Integer.parseInt(train[1]);
	    int dx = Integer.parseInt(train[2]);
	    int dy = Integer.parseInt(train[3]);
	    int gcd = getGcd(dx, dy);
	    dx /= gcd;
	    dy /= gcd;
	    double distance = getDis(xs, xe, ys, ye);
	    int x = 0;
	    int y = 0;
	    while(true) {
	        xe += dx;
	        ye += dy;
	        double dis = getDis(xs, xe, ys, ye);
	        if(distance > dis) {
	            distance = dis;
	        } else {
	            x = xe - dx;
	            y = ye - dy;
	            break;
	        }
	    }
	    System.out.print(x + " " + y);
	}
	
	private static double getDis(int x1, int x2, int y1, int y2) {
	    return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
	
	public static int getGcd(int a, int b) {
	    if(b == 0) {
	        return a;
	    }
	    return getGcd(b, a % b);
	    
	}

}