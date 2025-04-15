import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] matrix;
    static int[][] memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];
        memoization = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i][0] = r;
            matrix[i][1] = c;
        }

        System.out.println(merge(0, N - 1));
        br.close();
    }

    public static int merge(int start, int end) {
        if (start == end)
            return 0;

        if (memoization[start][end] != 0)
            return memoization[start][end];

        int answer = Integer.MAX_VALUE;

        int a = matrix[start][0];
        int c = matrix[end][1];
        for (int mid = start; mid < end; mid++) {
            int b = matrix[mid][1];

            int left = merge(start, mid);
            int right = merge(mid + 1, end);

            answer = Math.min(answer, a * b * c + left + right);
        }

        return memoization[start][end] = answer;
    }
}