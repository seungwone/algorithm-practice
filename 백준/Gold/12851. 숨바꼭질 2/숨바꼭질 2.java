import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        int[] distance = new int[100001];
        int[] count = new int[100001];

        for (int i = 0; i <= 100000; i++)
            distance[i] = Integer.MAX_VALUE;
        
        Deque<Integer[]> dq = new ArrayDeque<>();
        dq.add(new Integer[] {N, 0});

        while (!dq.isEmpty()) {
            Integer[] ele = dq.remove();
            int cur = ele[0];
            int price = ele[1];

            if (price > distance[K])
                break;

            if (distance[cur] > price) {
                distance[cur] = price;
                count[cur] = 1;
            }
            else if (distance[cur] == price) {
                count[cur]++;
            }
            else
                continue;

            if (cur - 1 >= 0) {
                dq.add(new Integer[] {cur - 1, price + 1});
            }

            if (cur + 1 <= 100000) {
                dq.add(new Integer[] {cur + 1, price + 1});
            }

            if (cur * 2 <= 100000) {
                dq.add(new Integer[] {cur * 2, price + 1});
            }
        }

        System.out.println(distance[K]);
        System.out.println(count[K]);
        br.close();
    }
}