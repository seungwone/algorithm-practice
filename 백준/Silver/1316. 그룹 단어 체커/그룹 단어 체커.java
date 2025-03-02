import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            Set<Character> set = new HashSet<>();

            String word = br.readLine();
            char prev = word.charAt(0);
            boolean isGroup = true;
            set.add(prev);
            for (int j = 1; j < word.length(); j++) {
                if (set.contains(word.charAt(j))) {
                    if (word.charAt(j) == prev) {
                        continue;
                    }
                    else {
                        isGroup = false;
                        break;
                    }
                }

                set.add(word.charAt(j));
                prev = word.charAt(j);
            }

            if (isGroup)
                answer++;
        }
        

        System.out.println(answer);
        br.close();
    }
}