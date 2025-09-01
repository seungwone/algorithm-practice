import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = K - 1;
        int[][] arr = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        for (int i = 0; i < K; i++) {
            for (int j = i + 1; j < K; j++) {
                int x1 = arr[i][0];
                int y1 = arr[i][1];
                int x2 = arr[j][0];
                int y2 = arr[j][1];
                int minX = Math.min(x1, x2);
                int maxY = Math.max(y1, y2);

                int temp = 0;
                for (int[] ele : arr) {
                    int x = ele[0];
                    int y = ele[1];
                    if (x >= minX && x <= minX + L && y >= maxY - L && y <= maxY) {
                        temp++;
                    }
                }
                answer = Math.min(answer, K - temp);
            }
        }

        System.out.println(answer);
        br.close();
    }
}