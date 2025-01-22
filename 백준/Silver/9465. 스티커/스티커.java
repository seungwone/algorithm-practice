import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                bw.write(String.valueOf(Math.max(sticker[0][0], sticker[1][0])));
                bw.newLine();
                continue;
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];

            for (int j = 2; j < n; j++) {
                for (int i = 0; i < 2; i++) {
                    if (i==1) {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j-2]) + sticker[i][j];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i+1][j-1], dp[i+1][j-2]) + sticker[i][j];
                    }
                }
            }

            bw.write(String.valueOf(Math.max(dp[0][n-1], dp[1][n-1])));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}