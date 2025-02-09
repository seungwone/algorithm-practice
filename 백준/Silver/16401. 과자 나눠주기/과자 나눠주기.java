import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());
        int[] snacks = new int[N];
        long total = 0;
        int result = 0;

        tk = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(tk.nextToken());
            total += snacks[i];
        }

        Arrays.sort(snacks);
        
        if (total < M) {
            System.out.println(0);
            return;
        }

        int left = 1;
        int right = snacks[N - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                count += snacks[i] / mid;
            }

            if (count >= M) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}