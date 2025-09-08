import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] adjLi;
    static int[] memo;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        adjLi = new List[N + 1];
        memo = new int[N + 1];
        isVisited = new boolean[N + 1];;

        for (int i = 1; i <= N; i++) {
            adjLi[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjLi[a].add(b);
            adjLi[b].add(a);
        }

        isVisited[R] = true;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int qRoot = Integer.parseInt(br.readLine());
            sb.append(memo[qRoot] + "\n");
        }
        
        System.out.print(sb);
        br.close();
    }

    public static int dfs(int root) {
        if (memo[root] != 0) {
            return memo[root];
        }

        int temp = 0;

        for (int node : adjLi[root]) {
            if (isVisited[node]) {
                continue;
            }
            isVisited[node] = true;

            temp += dfs(node);
        }

        memo[root] = temp + 1;
        return memo[root];
    }
}