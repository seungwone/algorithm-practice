import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] children = new List[n + 1];
        for (int i = 1; i <= n; i++)
            children[i] = new ArrayList<>();
        int[] parentDistance = new int[n + 1];
        int[] maxDistance = new int[n + 1];
        int[] parent = new int[n + 1];
        parent[1] = -1;

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            parent[c] = p;
            parentDistance[c] = d;

            children[p].add(c);
        }

        for (int i = 1; i <= n; i++) {
            if (children[i].size() != 0)
                continue;

            int cur = i;
            int val = 0;
            while (true) {
                if (parent[cur] == -1)
                    break;
                
                int next = parent[cur];
                int dist = parentDistance[cur];
                val += dist;
                maxDistance[next] = Math.max(maxDistance[next], val);

                cur = next;
            }

        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (children[i].size() == 0)
                continue;
            
            Queue<Integer> pq = new PriorityQueue<>();
            for (int e : children[i]) {
                int firstDist = parentDistance[e];
                int totalDist = firstDist + maxDistance[e];
                pq.add(totalDist);

                if (pq.size() > 2)
                    pq.remove();
            }

            int temp = 0;
            for (int e : pq) {
                temp += e;
            }

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
        br.close();
    }
}