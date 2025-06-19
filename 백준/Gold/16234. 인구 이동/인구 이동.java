import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        int answer = 0;

        int[][] A = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            boolean[][] isVisited = new boolean[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (isVisited[i][j]) {
                        continue;
                    }

                    int total = 0;
                    Deque<int[]> dq = new ArrayDeque<>();
                    List<int[]> list = new ArrayList<>();
                    dq.add(new int[] {i, j});
                    list.add(new int[] {i, j});

                    while (!dq.isEmpty()) {
                        int[] ele = dq.remove();
                        int curI = ele[0];
                        int curJ = ele[1];

                        isVisited[curI][curJ] = true;
                        total += A[curI][curJ];

                        for (int d = 0; d < 4; d++) {
                            int nextI = curI + di[d];
                            int nextJ = curJ + dj[d];

                            if (nextI >= 1 && nextI <= N && nextJ >= 1 && nextJ <= N && !isVisited[nextI][nextJ]) {
                                int gap = Math.abs(A[curI][curJ] - A[nextI][nextJ]);
                                if (gap >= L && gap <= R) {
                                    isChanged = true;
                                    isVisited[nextI][nextJ] = true;
                                    dq.add(new int[] {nextI, nextJ});
                                    list.add(new int[] {nextI, nextJ});
                                }
                            }
                        }
                    }

                    int newVal = total / list.size();
                    for (int[] region : list) {
                        A[region[0]][region[1]] = newVal;
                    }
                }
            }

            if (isChanged) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}