import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (dq.isEmpty()) {
                dq.add(y);
            }
            else if (dq.getLast() < y) {
                dq.add(y);
            }
            else {
                while (!dq.isEmpty() && dq.getLast() > y) {
                    dq.removeLast();
                    answer++;
                }
                if (dq.isEmpty())
                    dq.add(y);
                else if (dq.getLast() != y && y != 0)
                    dq.add(y);
            }
        }

        while (!dq.isEmpty() && dq.getLast() > 0) {
            dq.removeLast();
            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}