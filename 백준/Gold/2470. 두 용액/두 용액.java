import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> acid = new ArrayList<>();
        List<Integer> alkali = new ArrayList<>();
        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n >= 0)
                acid.add(n);
            else
                alkali.add(n);
        }

        Collections.sort(acid);
        Collections.sort(alkali);

        int minGap = Integer.MAX_VALUE;

        int idx1 = alkali.size() - 1;
        int idx2 = 0;

        if (alkali.size() >= 2) {
            minGap = Math.abs(alkali.get(idx1) + alkali.get(idx1 - 1));
            answer1 = alkali.get(idx1 - 1);
            answer2 = alkali.get(idx1);
        }
        if (acid.size() >= 2) {
            minGap = Math.min(minGap, acid.get(0) + acid.get(1));
            answer1 = acid.get(0);
            answer2 = acid.get(1);
        }

        while (idx1 >= 0 && idx2 < acid.size()) {
            int gap = alkali.get(idx1) + acid.get(idx2);
            int absGap = Math.abs(gap);
            
            if (absGap < minGap) {
                minGap = absGap;
                answer1 = alkali.get(idx1);
                answer2 = acid.get(idx2);
            }

            if (absGap == 0)
                break;
            
            if (gap > 0)
                idx1--;
            else
                idx2++;
        }

        System.out.println(answer1 + " " + answer2);
        br.close();
    }
}