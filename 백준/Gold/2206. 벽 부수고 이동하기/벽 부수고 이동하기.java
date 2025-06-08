import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N + 1][M + 1];
        boolean[][] isVisitedWithChance = new boolean[N + 1][M + 1];
        boolean[][] isVisitedWithNoChance = new boolean[N + 1][M + 1];
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        int answer = -1;

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = temp.charAt(j - 1) == '1';
            }
        }

        Deque<Integer[]> dq = new ArrayDeque<>();
        dq.add(new Integer[] {1, 1, 1, 1});
        isVisitedWithChance[1][1] = true;

        while (!dq.isEmpty()) {
            Integer[] ele = dq.remove();
            int curI = ele[0];
            int curJ = ele[1];
            int cnt = ele[2];
            int chance = ele[3];

            if (curI == N && curJ == M) {
                answer = cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextI = curI + di[d];
                int nextJ = curJ + dj[d];

                if (nextI >= 1 && nextI <= N && nextJ >= 1 && nextJ <= M) {

                    if (map[nextI][nextJ] == true) {
                        if (chance == 1 && !isVisitedWithNoChance[nextI][nextJ]) {
                            isVisitedWithNoChance[nextI][nextJ] = true;
                            dq.add(new Integer[] {nextI, nextJ, cnt + 1, 0});
                        }
                    }
                    else {
                        if (chance == 1 && !isVisitedWithChance[nextI][nextJ]) {
                            isVisitedWithChance[nextI][nextJ] = true;
                            dq.add(new Integer[] {nextI, nextJ, cnt + 1, chance});
                        }
                        else if (chance == 0 && !isVisitedWithNoChance[nextI][nextJ]) {
                            isVisitedWithNoChance[nextI][nextJ] = true;
                            dq.add(new Integer[] {nextI, nextJ, cnt + 1, chance});
                        }
                    }
                    
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}