import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    while(true) {
	        String m = br.readLine();
	        if(m.equals("0")) {
	            break;
	        }
	        int size = m.length();
	        int num = Integer.parseInt(m);
	        int newNum = num;
	        while(!isPalin(m, String.valueOf(newNum), size)) {
	            newNum++;
	        }
	        sb.append(newNum - num).append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
	private static boolean isPalin(String origin, String mileage, int size) {
	    int ms = mileage.length();
	    int fr = size - ms;
	    for(int i=0;i<size/2;i++) {
	        char a = (fr > i) 
	                    ? origin.charAt(i)
	                    : mileage.charAt(i-fr);
	        char b = (ms <= i) 
	                    ? origin.charAt(size-i-1)
	                    : mileage.charAt(ms-i-1);
	        if(a != b) {
	            return false;
	        }
	    }
	    return true;
	}
}