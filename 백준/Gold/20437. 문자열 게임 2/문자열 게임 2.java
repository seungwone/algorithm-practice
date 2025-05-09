import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            char[] arr = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());

            List<Integer>[] list = new List[26];
            for (int i = 0; i < 26; i++)
                list[i] = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                list[arr[i] - 'a'].add(i);
            }

            int answer1 = Integer.MAX_VALUE;
            int answer2 = -1;

            for (int i = 0; i < 26; i++) {
                if (list[i].size() < K)
                    continue;
                
                int start = 0;
                int end = start + K - 1;

                while (end < list[i].size()) {
                    int length = list[i].get(end) - list[i].get(start) + 1;
                    answer1 = Math.min(answer1, length);
                    answer2 = Math.max(answer2, length);

                    start++;
                    end++;
                }
            }

            if (answer1 == Integer.MAX_VALUE)
                answer1 = -1;
            
            if (answer1 == -1)
                sb.append(-1 + "\n");
            else {
                sb.append(answer1 + " " + answer2 + "\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}