import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] fuel = new int[N][M];
        int[] dj = {-1, 0, 1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                fuel[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                for (int d = 0; d < 3; d++)
                    dp[i][j][d] = Integer.MAX_VALUE;

        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++)
                dp[0][j][d] = fuel[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int prevI = i - 1;
                for (int d = 0; d < 3; d++) {
                    int prevJ = j + dj[d];

                    if (prevJ < 0 || prevJ >= M)
                        continue;

                    if (d == 0) {
                        dp[i][j][0] = Math.min(dp[prevI][prevJ][1], dp[prevI][prevJ][2]) + fuel[i][j];
                    }
                    else if (d == 1) {
                        dp[i][j][1] = Math.min(dp[prevI][prevJ][0], dp[prevI][prevJ][2]) + fuel[i][j];
                    }
                    else if (d == 2) {
                        dp[i][j][2] = Math.min(dp[prevI][prevJ][0], dp[prevI][prevJ][1]) + fuel[i][j];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N - 1][j][d]);
            }
        }

        System.out.println(answer);
        br.close();
    }
}