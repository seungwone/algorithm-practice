import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer[]> jewels = new ArrayList<>();
        Integer[] bags = new Integer[K];
        int[] isSelected = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Integer[] {M, V});
        }

        Collections.sort(jewels, (x, y) -> {
            if (x[0] == y[0])
                return Integer.compare(y[1], x[1]);
            return Integer.compare(x[0], y[0]);
        });

        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bags[i] = C;
        }

        Arrays.sort(bags);

        Queue<Integer[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < jewels.size() && jewels.get(j)[0] <= bags[i]) {
                int weight = jewels.get(j)[0];
                int price = jewels.get(j)[1];
                pq.add(new Integer[] {weight, price});
                j++;
            }

            if (!pq.isEmpty())
                answer += pq.remove()[1];
        }

        System.out.println(answer);
        br.close();
    }
}