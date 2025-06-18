import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] isVisited = new boolean[100001];
        long answer = 0;

        int j = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int front = arr[i];

            while (isVisited[front]) {
                answer += i - j;
                isVisited[arr[j]] = false;
                j++;
            }
            isVisited[front] = true;
        }

        for (int l = N - j; l > 0; l--) {
            answer += l;
        }

        System.out.println(answer);
        br.close();
    }
}