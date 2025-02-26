import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);

            // mCn
            long answer = 1;
            for (int j = M; j >= M - N + 1; j--)
                answer = answer * j / (1 + (M - j));

            sb.append(answer + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}