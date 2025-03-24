import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] adjList;
    static boolean isPossible;
    static Set<Integer>[] set;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < K; tc++) {
            isPossible = true;
            String[] temp = br.readLine().split(" ");
            int V = Integer.parseInt(temp[0]);
            int E = Integer.parseInt(temp[1]);
            adjList = new List[V + 1];
            for (int i = 1; i <= V; i++)
                adjList[i] = new ArrayList<>();
            isVisited = new boolean[V + 1];
            set = new Set[2];
            set[0] = new HashSet<>();
            set[1] = new HashSet<>();

            for (int i = 0; i < E; i++) {
                temp = br.readLine().split(" ");
                int u = Integer.parseInt(temp[0]);
                int v = Integer.parseInt(temp[1]);

                adjList[u].add(v);
                adjList[v].add(u);
            }

            for (int i = 1; i <= V; i++) {
                if (isVisited[i])
                    continue;
                dfs(i, 0);
            }

            for (int i = 1; i <= V; i++) {
                int idx = 0;
                if (set[1].contains(i))
                    idx = 1;

                for (int next : adjList[i]) {
                    if (set[idx].contains(next)) {
                        isPossible = false;
                        break;
                    }
                }

                if (!isPossible) {
                    break;
                }
            }

            String answer = isPossible ? "YES" : "NO";

            sb.append(answer + "\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static void dfs(int node, int setIdx) {
        isVisited[node] = true;

        int nextIdx = setIdx == 0 ? 1 : 0;

        set[setIdx].add(node);

        for (int next : adjList[node]) {
            if (isVisited[next])
                continue;

            dfs(next, nextIdx);
        }
    }
}