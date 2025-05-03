import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 2][m + 2];
        boolean[][] isVisited = new boolean[n + 2][m + 2];
        int initI = 0;
        int initJ = 0;
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    initI = i;
                    initJ = j;
                    map[i][j] = 0;
                    isVisited[i][j] = true;
                }
            }
        }

        Deque<Integer[]> dq = new ArrayDeque<>();
        dq.add(new Integer[] {initI, initJ, 0});

        while (!dq.isEmpty()) {
            Integer[] ele = dq.remove();
            int curI = ele[0];
            int curJ = ele[1];
            int distance = ele[2];

            for (int d = 0; d < 4; d++) {
                int nextI = curI + di[d];
                int nextJ = curJ + dj[d];

                if (!isVisited[nextI][nextJ] && map[nextI][nextJ] == 1) {
                    map[nextI][nextJ] = distance + 1;
                    isVisited[nextI][nextJ] = true;
                    dq.add(new Integer[] {nextI, nextJ, distance + 1});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1)
                    sb.append(-1 + " ");
                else
                    sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}