import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] inDegrees = new int[N + 1];
        Set<Integer>[] adjList = new Set[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new HashSet<>();

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int c = Integer.parseInt(temp[0]);
            for (int j = 1; j < c; j++) {
                int a = Integer.parseInt(temp[j]);
                int b = Integer.parseInt(temp[j + 1]);
                if (!adjList[a].contains(b)) {
                    adjList[a].add(b);
                    inDegrees[b]++;
                }
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int[] answer = new int[N];
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0)
                dq.add(i);
        }

        while (!dq.isEmpty()) {
            int cur = dq.remove();
            answer[cnt++] = cur;

            for (int e : adjList[cur]) {
                inDegrees[e]--;

                if (inDegrees[e] == 0) {
                    dq.add(e);
                }
            }
        }

        if (cnt != N)
            System.out.println(0);
        else {
            for (int e : answer)
                System.out.println(e);
        }

        br.close();
    }
}