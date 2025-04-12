import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] val = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            val[i] = Long.parseLong(st.nextToken());
        Arrays.sort(val);
        
        long minSum = Long.MAX_VALUE;
        Long[] answer = new Long[3];
        for (int a = 0; a < N; a++) {
            if (minSum == 0)
                break;

            for (int b = a + 1; b < N; b++) {
                if (minSum == 0)
                    break;

                long temp = val[a] + val[b];
                long minTemp = temp + val[0];
                long maxTemp = temp + val[N - 1];

                if (minTemp > 0 && minTemp > minSum)
                    break;
                if (maxTemp < 0 && Math.abs(maxTemp) > minSum)
                    break;

                for (int c = b + 1; c < N; c++) {
                    if (minSum == 0)
                        break;

                    long sum = Math.abs(val[a] + val[b] + val[c]);
                    if (sum < minSum) {
                        minSum = sum;
                        answer[0] = val[a];
                        answer[1] = val[b];
                        answer[2] = val[c];
                    }
                }
            }
        }
        Arrays.sort(answer);

        for (long e : answer)
            System.out.print(e + " ");
        System.out.println();
        br.close();
    }
}