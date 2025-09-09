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
        List<int[]> edges = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new int[] {A, B, C});
        }

        Collections.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));

        int cnt = 0;

        for (int[] ele : edges) {
            if (cnt == N - 2) {
                break;
            }

            int A = ele[0];
            int B = ele[1];
            int C = ele[2];

            if (find(A) == find(B)) {
                continue;
            }

            union(A, B);
            answer += C;
            cnt++;
        }

        System.out.println(answer);
        br.close();
    }
}