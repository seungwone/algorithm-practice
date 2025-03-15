import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int dest;
        int price;

        public Edge(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            boolean isPossible = false;
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            List<Edge>[] adjLists = new List[N + 1];
            for (int i = 1; i <= N; i++)
                adjLists[i] = new ArrayList<>();
            int M = Integer.parseInt(temp[1]);
            int W = Integer.parseInt(temp[2]);

            for (int i = 0; i < M; i++) {
                temp = br.readLine().split(" ");
                int S = Integer.parseInt(temp[0]);
                int E = Integer.parseInt(temp[1]);
                int T = Integer.parseInt(temp[2]);
                adjLists[S].add(new Edge(E, T));
                adjLists[E].add(new Edge(S, T));
            }

            for (int i = 0; i < W; i++) {
                temp = br.readLine().split(" ");
                int S = Integer.parseInt(temp[0]);
                int E = Integer.parseInt(temp[1]);
                int T = Integer.parseInt(temp[2]);
                adjLists[S].add(new Edge(E, -T));
            }

            int[] distance = new int[N + 1];
            Arrays.fill(distance, 1234567890);
            distance[1] = 0;

            for (int c = 1; c <= N; c++) {
                boolean isUpdated = false;
                for (int i = 1; i <= N; i++) {
                    int curVal = distance[i];

                    for (Edge edge : adjLists[i]) {
                        int dest = edge.dest;
                        int price = edge.price;

                        if (distance[dest] > curVal + price) {
                            distance[dest] = curVal + price;
                            isUpdated = true;
                            if (c == N)
                                isPossible = true;
                        }
                    }
                }
                if (!isUpdated)
                    break;

                if (isPossible)
                    break;
            }

            String answer = isPossible ? "YES" : "NO";
            sb.append(answer + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}