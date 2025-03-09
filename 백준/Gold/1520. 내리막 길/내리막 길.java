import java.io.*;
import java.util.*;

class Main {
    static int M;
    static int N;
    static int[][] map;
    static int[][] count;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]);
        N = Integer.parseInt(temp[1]);
        map = new int[M][N];
        count = new int[M][N];

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                count[i][j] = -1;
            }
        }

        count[M - 1][N - 1] = 1;

        System.out.println(dfs(0, 0));
        br.close();
    }

    public static int dfs(int curI, int curJ) {
        int curH = map[curI][curJ];
        
        if (count[curI][curJ] != -1)
            return count[curI][curJ];

        if (count[curI][curJ] == -1)
            count[curI][curJ] = 0;

        for (int d = 0; d < 4; d++) {
            int nextI = curI + di[d];
            int nextJ = curJ + dj[d];

            if (nextI >= 0 && nextI < M && nextJ >= 0 && nextJ < N && curH > map[nextI][nextJ]) {
                count[curI][curJ] += dfs(nextI, nextJ);
            }
        }

        return count[curI][curJ];
    }
}
