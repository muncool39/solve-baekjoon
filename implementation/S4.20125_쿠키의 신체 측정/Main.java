import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    char[][] cookie = new char[N][N];
	    for(int i=0;i<N;i++) {
	        cookie[i] = br.readLine().toCharArray();
	    }
	    int hx = 0;
	    int hy = 0;
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<N;j++) {
	            if(cookie[i][j] == '*') {
	                hx = i+1;
	                hy = j;
	                break;
	            }
	        }
	        if(hx > 0) {
	            break;
	        }
	    }
	    int armL = 0;
	    for(int y=hy-1;y>=0;y--) {
	        if(cookie[hx][y] == '*') {
	            armL++;
	        } else {
	            break;
	        }
	    }
	    int armR = 0;
	    for(int y=hy+1;y<N;y++) {
	        if(cookie[hx][y] == '*') {
	            armR++;
	        } else {
	            break;
	        }
	    }
	    int waist = 0;
	    for(int x=hx+1;x<N;x++) {
	        if(cookie[x][hy] == '*') {
	            waist++;
	        } else {
	            break;
	        }
	    }
	    int legL = 0;
	    for(int x=(hx+waist+1);x<N;x++) {
	        if(cookie[x][hy-1] == '*') {
	            legL++;
	        } else {
	            break;
	        }
	    }
	    int legR = 0;
	    for(int x=(hx+waist+1);x<N;x++) {
	        if(cookie[x][hy+1] == '*') {
	            legR++;
	        } else {
	            break;
	        }
	    }
	    hx++;
	    hy++;
	    System.out.println(hx + " " + hy);
	    System.out.print(armL + " " + armR + " " + waist + " " + legL + " " + legR);
	}
	

}