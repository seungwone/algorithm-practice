import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringBuilder answer = new StringBuilder();
            answer.append("[");
            String p = br.readLine();
            br.readLine();
            Deque<Integer> dq = new ArrayDeque<>();
            String tempStr = br.readLine();
            tempStr = tempStr.substring(1, tempStr.length() - 1);
            String[] temp = tempStr.split(",");
            for (String str : temp) {
                if (str.equals(""))
                    continue;
                dq.add(Integer.parseInt(str));
            }

            boolean isReverse = false;
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);

                if (c == 'R') {
                    isReverse = !isReverse;
                    continue;
                }

                if (dq.isEmpty()) {
                    answer = new StringBuilder();
                    answer.append("error");
                    break;
                }

                if (isReverse) {
                    dq.removeLast();
                }
                else {
                    dq.removeFirst();
                }

            }

            if (!answer.toString().equals("error")) {
                if (isReverse) {
                    while (!dq.isEmpty()) {
                        answer.append(dq.removeLast()+",");
                    }
                }
                else {
                    while (!dq.isEmpty()) {
                        answer.append(dq.removeFirst()+",");
                    }
                }

                if (answer.length() > 1) {
                    answer.deleteCharAt(answer.length() - 1);
                }

                answer.append("]");
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}