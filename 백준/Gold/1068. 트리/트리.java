import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] adjList = new List[N];
        for (int i = 0; i < N; i++)
            adjList[i] = new ArrayList<>();

        String[] temp = br.readLine().split(" ");
        int root = 0;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(temp[i]);

            if (parent == -1) {
                root = i;
                continue;
            }

            adjList[parent].add(i);
        }

        int remove = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        if (root != remove)
            dq.add(root);

        while (!dq.isEmpty()) {
            int cur = dq.remove();

            boolean isReaf = true;

            for (int next : adjList[cur]) {
                if (next == remove)
                    continue;
                dq.add(next);
                isReaf = false;
            }

            if (isReaf)
                answer++;
        }

        System.out.println(answer);
        br.close();
    }
}