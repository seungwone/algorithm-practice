import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] times = new long[N + 1];
            long[] distance = new long[N + 1];
            for (int i = 1; i <= N; i++)
                times[i] = Long.parseLong(st.nextToken());

            List<Integer>[] adjList = new List[N + 1];
            for (int i = 1; i <= N; i++)
                adjList[i] = new ArrayList<>();
            int[] inDegrees = new int[N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adjList[X].add(Y);
                inDegrees[Y]++;
            }

            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (inDegrees[i] == 0) {
                    distance[i] = times[i];
                    dq.add(i);
                }
            }

            while (!dq.isEmpty()) {
                int cur = dq.remove();

                for (int next : adjList[cur]) {
                    distance[next] = Math.max(distance[next], distance[cur] + times[next]);
                    inDegrees[next]--;
                    if (inDegrees[next] == 0)
                        dq.add(next);
                }
            }

            int W = Integer.parseInt(br.readLine());
            sb.append(distance[W] + "\n");
        }

        System.out.print(sb);
        br.close();
    }
}