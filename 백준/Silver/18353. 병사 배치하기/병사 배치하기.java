import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(tk.nextToken());
        // dp[N][1] -> N번재 요소 선택, dp[N][0] -> N번째 요소 미선택
        dp[0][1] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][1] = 1;
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > arr[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
                j--;
            }

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(arr.length - Math.max(dp[N-1][0], dp[N-1][1]));

        br.close();
    }
}