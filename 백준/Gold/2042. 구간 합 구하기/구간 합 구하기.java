import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int K = Integer.parseInt(temp[2]);

        int size = 1;
        while (N > size)
            size *= 2;
        size *= 2;
        long[] tree = new long[size];

        // 트리 초기화
        for (int i = 0; i < N; i++) {
            int idx = size / 2 + i;
            long val = Long.parseLong(br.readLine());
            while (idx > 0) {
                tree[idx] += val; 
                idx /= 2;
            }
        }

        for (int i = 0; i < M + K; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            long c = Long.parseLong(temp[2]);

            // update
            if (a == 1) {
                int idx = size / 2 + b - 1;
                long gap = c - tree[idx];
                while (idx > 0) {
                    tree[idx] += gap;
                    idx /= 2;
                }
            }
            // 합 구하기
            else {
                int startIdx = size / 2 + b - 1;
                int endIdx = size / 2 + (int) c - 1;
                long sum = 0;
                while (startIdx <= endIdx) {
                    if (startIdx % 2 == 1) {
                        sum += tree[startIdx];
                        startIdx++;
                    }
                    if (endIdx % 2 == 0) {
                        sum += tree[endIdx];
                        endIdx--;
                    }
                    startIdx /= 2;
                    endIdx /= 2;
                }
                sb.append(sum + "\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}