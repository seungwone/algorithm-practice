import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int len = bomb.length();
        String answer = "FRULA";
        
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        int cur = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.add(c);

            if (c == bomb.charAt(cur)) {
                cur++;
            }
            else if (c == bomb.charAt(0)) {
                stack2.add(cur);
                cur = 1;
            }
            else {
                stack2 = new ArrayDeque<>();
                cur = 0;
            }

            if (cur == len) {
                for (int l = 0; l < len; l++) {
                    stack.removeLast();
                }
                cur = 0;

                if (!stack2.isEmpty()) {
                    cur = stack2.removeLast();
                }
            }

        }

        if (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            answer = sb.toString();
        }
        
        System.out.println(answer);
        br.close();
    }
}