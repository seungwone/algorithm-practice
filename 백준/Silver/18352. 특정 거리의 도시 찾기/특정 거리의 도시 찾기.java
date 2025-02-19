import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int X = Integer.parseInt(tk.nextToken());
        List<Integer>[] adjList = new ArrayList[N + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int[] distance = new int[N + 1];

        for (int i = 1; i <= N; i++) distance[i] = Integer.MAX_VALUE;
        distance[X] = 0;

        for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(tk.nextToken());
            int B = Integer.parseInt(tk.nextToken());
            adjList[A].add(B);
        }

        dq.add(X);

        while (!dq.isEmpty()) {
            int cur = dq.remove();
            int d = distance[cur];

            for (int e : adjList[cur]) {
                if (distance[e] == Integer.MAX_VALUE) {
                    distance[e] = d + 1;
                    dq.add(e);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) answer.add(i);
        }

        if (answer.isEmpty()) {
            sb.append(-1 + "\n");
        }
        else {
            Collections.sort(answer);
            for (int e : answer) sb.append(e + "\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}