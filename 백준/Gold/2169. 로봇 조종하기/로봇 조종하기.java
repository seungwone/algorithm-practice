import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        int[][][] dp = new int[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        dp[1][1][0] = arr[1][1];
        for (int j = 2; j <= M; j++) {
            dp[1][j][0] = dp[1][j - 1][0] + arr[1][j];
        }

        for (int i = 2; i <= N; i++) {

            // 오른쪽으로 탐색
            for (int j = 1; j <= M; j++) {
                int prev = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);

                for (int idx = j; idx <= M; idx++) {
                    int newVal = prev + arr[i][idx];
                    if (newVal <= dp[i][idx][0])
                        break;
                    dp[i][idx][0] = newVal;
                    prev = newVal;
                }
            }

            // 왼쪽으로 탐색
            for (int j = M; j >= 1; j--) {
                int prev = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);

                for (int idx = j; idx >= 1; idx--) {
                    int newVal = prev + arr[i][idx];
                    if (newVal <= dp[i][idx][1])
                        break;
                    dp[i][idx][1] = newVal;
                    prev = newVal;
                }
            }

        }

        System.out.println(Math.max(dp[N][M][0], dp[N][M][1]));
        br.close();
    }
}