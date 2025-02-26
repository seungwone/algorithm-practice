import java.io.*;
import java.util.*;

class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int K = Integer.parseInt(temp[0]);
        int N = Integer.parseInt(temp[1]);
        int[] lan = new int[K];
        for (int i = 0; i < K; i++) 
            lan[i] = Integer.parseInt(br.readLine());
        
        long left = 1;
        long right = Integer.MAX_VALUE;
        int answer = Integer.MIN_VALUE;

        while (left <= right) {
            count = 0;
            long mid = (left + right) / 2;
            for (int l : lan) {
                count += l / mid;
            }

            if (count >= N) {
                left = mid + 1;
                answer = Math.max(answer, (int) mid);
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}