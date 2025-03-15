import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];
        minDp[0][0] = maxDp[0][0] = map[0][0];
        minDp[0][1] = maxDp[0][1] = map[0][1];
        minDp[0][2] = maxDp[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            int minPrev0 = minDp[i - 1][0];
            int minPrev1 = minDp[i - 1][1];
            int minPrev2 = minDp[i - 1][2];

            minDp[i][0] = Math.min(minPrev0, minPrev1) + map[i][0];
            minDp[i][1] = Math.min(Math.min(minPrev0, minPrev1), minPrev2) + map[i][1];
            minDp[i][2] = Math.min(minPrev1, minPrev2) + map[i][2];

            int maxPrev0 = maxDp[i - 1][0];
            int maxPrev1 = maxDp[i - 1][1];
            int maxPrev2 = maxDp[i - 1][2];

            maxDp[i][0] = Math.max(maxPrev0, maxPrev1) + map[i][0];
            maxDp[i][1] = Math.max(Math.max(maxPrev0, maxPrev1), maxPrev2) + map[i][1];
            maxDp[i][2] = Math.max(maxPrev1, maxPrev2) + map[i][2];
        }

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int j = 0; j < 3; j++) {
            maxVal = Math.max(maxVal, maxDp[N - 1][j]);
            minVal = Math.min(minVal, minDp[N - 1][j]);
        }
        
        System.out.println(maxVal + " " + minVal + "\n");
        br.close();
    }
}