import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] home = new int[N + 2][N + 2];

        for (int i = 0; i < N + 2; i++) {
            home[i][0] = 1;
            home[i][N + 1] = 1;
            home[0][i] = 1;
            home[N + 1][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                home[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        // 가로 : 0
        // 세로 : 1
        // 대각선 : 2
        long[][][] dp = new long[N + 2][N + 2][3];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (home[i][j] == 1)
                    continue;
                
                if (i == 1 && j == 2) {
                    dp[1][2][0] = 1;
                    continue;
                }

                // 가로
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                // 세로
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                // 대각선
                if (home[i - 1][j] == 0 && home[i][j - 1] == 0)
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
        br.close();
    }
}