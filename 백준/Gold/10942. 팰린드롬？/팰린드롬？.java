import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int[][] memoization;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        memoization = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            Arrays.fill(memoization[i], -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dfs(S, E) + "\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static int dfs(int start, int end) {
        if (start == end)
            return memoization[start][end] = 1;

        if (end - start == 1) {
            if (arr[start] == arr[end])
                memoization[start][end] = 1;
            else
                memoization[start][end] = 0;

            return memoization[start][end];
        }

        if (memoization[start + 1][end - 1] == 0)
            return memoization[start][end] = 0;

        if (memoization[start + 1][end - 1] == 1) {
            if (arr[start] == arr[end]) 
                memoization[start][end] = 1;
            else
                memoization[start][end] = 0;

            return memoization[start][end];
        }

        if (arr[start] != arr[end])
            return memoization[start][end] = 0;
        
        return memoization[start][end] = dfs(start + 1, end - 1);
    }
}