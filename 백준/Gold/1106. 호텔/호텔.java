import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] input = new int[N];
        int[] output = new int[N];
        int[] dp = new int[100001];

        for (int i = 1; i < 100001; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
            output[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int in = input[i];
            int out = output[i];

            for (int idx = 0; idx < 100001; idx++) {
                if (dp[idx] != -1 && idx + in < 100001) {
                    
                    if (dp[idx + in] == -1) {
                        dp[idx + in] = dp[idx] + out;
                    }
                    else {
                        dp[idx + in] = Math.max(dp[idx + in], dp[idx] + out);
                    }
                }
            }
        }

        for (int idx = 1; idx < 100001; idx++) {
            if (dp[idx] >= C) {
                System.out.println(idx);
                break;
            }
        }
        
        br.close();
    }
}