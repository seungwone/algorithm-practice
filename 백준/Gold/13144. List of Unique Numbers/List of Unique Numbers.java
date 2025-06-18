import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        for (int i = 0; i < N; i++) {
            int front = arr[i];

            while (set.contains(front)) {
                answer += i - j;
                set.remove(arr[j]);
                j++;
            }
            set.add(front);
        }

        for (int l = set.size(); l > 0; l--) {
            answer += l;
        }

        System.out.println(answer);
        br.close();
    }
}