import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int answer = 0;
        int M = Integer.parseInt(temp[0]);
        int N = Integer.parseInt(temp[1]);
        int H = Integer.parseInt(temp[2]);
        int[][][] box = new int[H + 2][N + 2][M + 2];
        for (int h = 0; h < H + 2; h++)
            for (int i = 0; i < N + 2; i++)
                for (int j = 0; j < M + 2; j++)
                    box[h][i][j] = -1;
        Deque<Integer[]> dq = new ArrayDeque<>();
        int[] dh = {1, -1, 0, 0, 0, 0};
        int[] di = {0, 0, -1, 1, 0, 0};
        int[] dj = {0, 0, 0, 0, -1, 1};

        int totalCnt = 0;
        for (int h = 1; h <= H; h++) {
            for (int i = 1; i <= N; i++) {
                temp = br.readLine().split(" ");
                for (int j = 1; j <= M; j++) {
                    box[h][i][j] = Integer.parseInt(temp[j - 1]);

                    if (box[h][i][j] == 0)
                        totalCnt++;

                    if (box[h][i][j] == 1) {
                        dq.add(new Integer[] {h, i, j, 0});
                    }
                }
            }
        }

        while (!dq.isEmpty()) {
            Integer[] ele = dq.remove();
            int curH = ele[0];
            int curI = ele[1];
            int curJ = ele[2];
            int curDay = ele[3];

            answer = curDay;

            for (int d = 0; d < 6; d++) {
                int nextH = curH + dh[d];
                int nextI = curI + di[d];
                int nextJ = curJ + dj[d];

                if (box[nextH][nextI][nextJ] == 0) {
                    box[nextH][nextI][nextJ] = 1;
                    totalCnt--;
                    dq.add(new Integer[] {nextH, nextI, nextJ, curDay + 1});
                }
            }
        }

        if (totalCnt != 0)
            answer = -1;

        System.out.println(answer);
        br.close();
    }
}