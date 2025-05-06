import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] hArr = new int[H + 1];

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= W; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int n = 1; n <= h; n++) {
                if (hArr[n] == 0) {
                    hArr[n] = i;
                    continue;
                }

                answer += i - hArr[n] - 1;
                hArr[n] = i;
            }
        }

        System.out.println(answer);
        br.close();
    }
}