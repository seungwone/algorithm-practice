import java.io.*;
import java.util.*;

class Main {
    static List<Integer[]> birus;
    static int N;
    static int M;
    static int[] comb;
    static boolean[][] isVisited;
    static int[][] laboratory;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int answer = 0;
    static int zeroCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        comb = new int[M];
        birus = new ArrayList<>();
        laboratory = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            laboratory[0][i] = -1;
            laboratory[N + 1][i] = -1;
            laboratory[i][0] = -1;
            laboratory[i][N + 1] = -1;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
                int val = laboratory[i][j];
                if (val == 0)
                    zeroCnt++;
                if (val == 1)
                    laboratory[i][j] = -1;
                if (val == 2) {
                    birus.add(new Integer[] {i, j});
                    laboratory[i][j] = 0;
                    zeroCnt++;
                }
            }
        }

        combination(0, 0);

        if (answer == Integer.MAX_VALUE)
            answer = -1;

        System.out.println(answer);
        br.close();
    }

    static void combination(int cnt, int start) {
        if (cnt == M) {
            Deque<Integer[]> dq = new ArrayDeque<>();
            isVisited = new boolean[N + 2][N + 2];

            int endTime = Integer.MIN_VALUE;
            int birusCnt = 0;

            for (int i = 0; i < M; i++) {
                Integer[] ele = birus.get(comb[i]);
                int curI = ele[0];
                int curJ = ele[1];
                isVisited[curI][curJ] = true;
                dq.add(new Integer[] {curI, curJ, 0});
            }

            while (!dq.isEmpty()) {
                Integer[] ele = dq.remove();
                int curI = ele[0];
                int curJ = ele[1];
                int time = ele[2];

                endTime = Math.max(endTime, time);
                birusCnt++;

                for (int d = 0; d < 4; d++) {
                    int nextI = curI + di[d];
                    int nextJ = curJ + dj[d];

                    if (laboratory[nextI][nextJ] != -1 && !isVisited[nextI][nextJ]) {
                        isVisited[nextI][nextJ] = true;
                        dq.add(new Integer[] {nextI, nextJ, time + 1});
                    }
                }

            }

            if (birusCnt == zeroCnt) {
                answer = Math.min(answer, endTime);
            }

            return;
        }

        for (int i = start; i < birus.size(); i++) {
            comb[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }
}