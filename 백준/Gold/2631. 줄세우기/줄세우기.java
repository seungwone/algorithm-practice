import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int maxVal = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            int temp = 0;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[i]) {
                    continue;
                }

                temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            maxVal = Math.max(maxVal, dp[i]);
        }

        System.out.println(N - maxVal);
        br.close();
    }
}