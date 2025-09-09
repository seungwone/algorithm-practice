import java.io.*;
import java.util.*;

class Main {
    static int[] parent;

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX < rootY) {
            parent[rootY] = rootX;
        }
        else {
            parent[rootX] = rootY;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        Integer[][] edges = new Integer[M][3];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));

        int cnt = 0;
        int temp = Integer.MIN_VALUE;

        for (Integer[] ele : edges) {
            int A = ele[0];
            int B = ele[1];
            int C = ele[2];

            if (find(A) == find(B)) {
                continue;
            }

            union(A, B);
            answer += C;
            temp = Math.max(temp, C);
            cnt++;

            if (cnt == N - 1) {
                break;
            }
        }

        System.out.println(answer - temp);
        br.close();
    }
}