import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            int start = 0;
            int end = 0 + mid - 1;

            int sum = 0;
            for (int i = start; i <= end; i++)
                sum += arr[i];
            
            boolean isPossible = false;
            while (true) {
                if (sum >= S) {
                    isPossible = true;
                    break;
                }

                sum -= arr[start];
                start++;
                end++;
                if (end >= N)
                    break;
                sum += arr[end];
            }

            if (isPossible) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
