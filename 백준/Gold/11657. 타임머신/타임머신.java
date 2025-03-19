import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        List<Integer[]>[] paths = new List[N + 1];
        for (int i = 1; i <= N; i++)
            paths[i] = new ArrayList<>();
        long[] distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);
            int C = Integer.parseInt(temp[2]);

            paths[A].add(new Integer[] {B, C});
        }

        boolean isInfinite = false;

        for (int c = 1; c <= N; c++) {
            boolean isUpdated = false;

            for (int i = 1; i <= N; i++) {
                long curDistance = distance[i];

                if (curDistance == Long.MAX_VALUE)
                    continue;

                for (Integer[] ele : paths[i]) {
                    int dest = ele[0];
                    int price = ele[1];

                    if (distance[dest] > curDistance + price) {
                        isUpdated = true;

                        if (c == N) {
                            isInfinite = true;
                            break;
                        }

                        distance[dest] = curDistance + price;
                    }
                }

                if (isInfinite)
                    break;
            }

            if (!isUpdated)
                break;
        }

        if (isInfinite) {
            sb.append(-1 + "\n");
        }
        else {
            for (int i = 2; i <= N; i++)
                sb.append((distance[i] == Long.MAX_VALUE ? -1 : distance[i]) + "\n");
        }

        System.out.print(sb);
        br.close();
    }
}