import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] odd = new int[N];
        int[] even = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            even[i] = even[i - 1];
            odd[i] = odd[i - 1];

            if (i % 2 == 0)
                even[i] += n;
            else
                odd[i] += n;
        }
        int last = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int val = odd[i - 1] + even[N - 1] - even[i - 1];

            if (i % 2 != 0)
                val += last;
            
            answer = Math.max(answer, val);
        }

        System.out.println(answer);
        br.close();
    }
}