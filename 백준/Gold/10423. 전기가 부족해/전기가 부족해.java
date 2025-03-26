import java.io.*;
import java.util.*;

class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        int[] power = new int[K];
        st = new StringTokenizer(br.readLine());
        power[0] = Integer.parseInt(st.nextToken());
        int idx = power[0];
        for (int i = 1; i < K; i++) {
            power[i] = Integer.parseInt(st.nextToken());
            union(idx, power[i]);
        }

        List<Integer[]>[] adjList = new List[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Integer[] {u, v, w});
            adjList[v].add(new Integer[] {v, u, w});
        }

        Queue<Integer[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[2], y[2]));
        for (int i = 0; i < K; i++) {
            int cur = power[i];

            for (Integer[] ele : adjList[cur]) {
                pq.add(ele);
            }
        }

        int cnt = K;
        int answer = 0;
        while (!pq.isEmpty()) {
            if (cnt == N)
                break;

            Integer[] ele = pq.remove();
            int aRoot = find(ele[0]);
            int bRoot = find(ele[1]);
            int cost = ele[2];

            if (aRoot == bRoot)
                continue;

            union(aRoot, bRoot);

            for (Integer[] next : adjList[ele[1]]) {
                pq.add(next);
            }

            answer += cost;
            cnt++;
        }

        System.out.println(answer);
        br.close();
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot)
            parent[bRoot] = aRoot;
        else
            parent[aRoot] = bRoot;
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
}