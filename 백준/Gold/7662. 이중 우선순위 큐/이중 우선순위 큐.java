import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            int T = Integer.parseInt(br.readLine());
            Queue<Integer> maxPQ = new PriorityQueue<>((x, y) -> x < y ? 1 : x == y ? 0 : -1);
            Queue<Integer> minPQ = new PriorityQueue<>();
            int cnt = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < T; i++) {
                String[] temp = br.readLine().split(" ");

                if (temp[0].equals("I")) {
                    int val = Integer.parseInt(temp[1]);
                    maxPQ.add(val);
                    minPQ.add(val);
                    cnt++;

                    if (map.containsKey(val)) {
                        map.put(val, map.get(val) + 1);
                    }
                    else {
                        map.put(val, 1);
                    }

                    continue;
                }

                if (cnt == 0)
                    continue;

                if (temp[1].equals("-1")) {
                    while (map.get(minPQ.peek()) == 0) {
                        minPQ.remove();
                    }
                    int del = minPQ.remove();
                    map.put(del, map.get(del) - 1);
                    cnt--;

                    continue;
                }

                while (map.get(maxPQ.peek()) == 0) {
                    maxPQ.remove();
                }
                int del = maxPQ.remove();
                map.put(del, map.get(del) - 1);
                cnt--;

            }

            if (cnt == 0) {
                sb.append("EMPTY\n");
                continue;
            }
            while (map.get(maxPQ.peek()) == 0) {
                maxPQ.remove();
            }
            sb.append(maxPQ.peek() + " ");

            while (map.get(minPQ.peek()) == 0) {
                minPQ.remove();
            }
            sb.append(minPQ.peek() + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}
