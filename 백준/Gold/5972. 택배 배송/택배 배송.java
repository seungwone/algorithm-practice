import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] adjLi = new List[N + 1];
        int[] answer = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adjLi[i] = new ArrayList<>();
            answer[i] = 123456789;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adjLi[A].add(new int[] {C, B});
            adjLi[B].add(new int[] {C, A});
        }
        
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        pq.add(new int[] {0, 1});
        answer[1] = 0;

        while (!pq.isEmpty()) {
            int[] ele = pq.remove();
            int price = ele[0];
            int dest = ele[1];

            if (price != answer[dest]) {
                continue;
            }

            for (int[] next : adjLi[dest]) {
                int nextPrice = next[0];
                int nextDest = next[1];

                if (price + nextPrice < answer[nextDest]) {
                    pq.add(new int[] {price + nextPrice, nextDest});
                    answer[nextDest] = price + nextPrice;
                }
            }
        }

        System.out.println(answer[N]);
        br.close();
    }
}