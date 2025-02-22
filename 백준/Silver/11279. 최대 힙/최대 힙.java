import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
                continue;
            }

            if (pq.isEmpty()) {
                sb.append(0 + "\n");
                continue;
            }

            sb.append(pq.remove() + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}