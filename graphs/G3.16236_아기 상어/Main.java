import java.io.*;
import java.util.*;

public class Main{
    static int[][] space;
    static int N;
    static int sharkSize = 2;
    static int sharkEat = 0;
    static int time = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];
        int startX = 0, startY = 0;
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(input[j]);
                if (space[i][j] == 9) {
                    startX = i;
                    startY = j;
                    space[i][j] = 0;
                }
            }
	    }
	    
	    while (true) {
            int[] fish = findFish(startX, startY);
            if (fish == null) break; 
            startX = fish[0];
            startY = fish[1];
            space[startX][startY] = 0;
            time += fish[2];
            sharkEat++;
            if (sharkEat == sharkSize) {
                sharkSize++;
                sharkEat = 0;
            }
        }

        System.out.println(time);
	    
	}
	
	public static int[] findFish(int startX, int startY) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        int[] bestFish = null;
        int bestDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            if (dist > bestDist) continue;
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (space[nx][ny] > 0 && space[nx][ny] < sharkSize) {
                        if (dist + 1 < bestDist) {
                            bestDist = dist + 1;
                            bestFish = new int[]{nx, ny, bestDist};
                        } else if (dist + 1 == bestDist) {
                            if (bestFish == null || nx < bestFish[0] || (nx == bestFish[0] && ny < bestFish[1])) {
                                bestFish = new int[]{nx, ny, dist + 1};
                            }
                        }
                    }
                    if (space[nx][ny] == 0 || space[nx][ny] == sharkSize) {
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return bestFish;
    }
}
