import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] di = {1, 0};
        int[] dj = {0, 1};
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] isVisited = new boolean[N][N];
        Deque<Integer[]> dq = new ArrayDeque<>();
        String answer = "Hing";

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dq.add(new Integer[] {0, 0});
        isVisited[0][0] = true;

        while (!dq.isEmpty()) {
            Integer[] ele = dq.remove();
            int curI = ele[0];
            int curJ = ele[1];
            int weight = map[curI][curJ];

            if (weight == -1) {
                answer = "HaruHaru";
                break;
            }

            if (weight == 0)
                continue;

            for (int d = 0; d < 2; d++) {
                int nextI = curI + di[d] * weight;
                int nextJ = curJ + dj[d] * weight;

                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N && !isVisited[nextI][nextJ]) {
                    isVisited[nextI][nextJ] = true;
                    dq.add(new Integer[] {nextI, nextJ});
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}