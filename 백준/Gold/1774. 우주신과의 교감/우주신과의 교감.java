import java.io.*;
import java.util.*;

class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        int[][] node = new int[N + 1][2];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            node[i][0] = X;
            node[i][1] = Y;
        }

        List<Object[]> edges = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                long aX = node[i][0];
                long aY = node[i][1];
                long bX = node[j][0];
                long bY = node[j][1];

                long x2 = Math.abs(aX - bX);
                x2 *= x2;
                long y2 = Math.abs(aY - bY);
                y2 *= y2;
                
                double distance = Math.sqrt(x2 + y2);

                edges.add(new Object[] {i, j, distance});
            }
        }

        Collections.sort(edges, (x, y) -> Double.compare((Double) x[2], (Double) y[2]));

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int aIdx = Integer.parseInt(st.nextToken());
            int bIdx = Integer.parseInt(st.nextToken());

            long aX = node[aIdx][0];
            long aY = node[aIdx][1];
            long bX = node[bIdx][0];
            long bY = node[bIdx][1];

            long x2 = Math.abs(aX - bX);
            x2 *= x2;
            long y2 = Math.abs(aY - bY);
            y2 *= y2;

            int aRoot = find(aIdx);
            int bRoot = find(bIdx);

            if (aRoot == bRoot)
                continue;

            union(aIdx, bIdx);
            cnt++;
        }

        for (Object[] ele : edges) {
            if (cnt == N - 1)
                break;

            Integer aIdx = (Integer) ele[0];
            Integer bIdx = (Integer) ele[1];
            Double distance = (Double) ele[2];

            int aRoot = find(aIdx);
            int bRoot = find(bIdx);

            if (aRoot == bRoot)
                continue;
            
            union(aRoot, bRoot);
            answer += distance;
            cnt++;
        }

        System.out.println(String.format("%.2f", answer));
        br.close();
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot) {
            parent[bRoot] = aRoot;
        }
        else {
            parent[aRoot] = bRoot;
        }
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
}