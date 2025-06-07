import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Map> trie = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        int maxVal = 0;
        int sIdx = Integer.MAX_VALUE;
        String prefix = "";
        String answer1 = "";
        String answer2 = "";

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            if (set.contains(temp))
                continue;
            set.add(temp);
            list.add(temp);

            if (set.size() == 1)
                answer1 = temp;
            if (set.size() == 2)
                answer2 = temp;

            Map node = trie;
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : temp.toCharArray()) {
                if (node.containsKey(c)) {
                    cnt++;
                    sb.append(c);
                    node = (Map) node.get(c);
                }
                else {
                    node.put(c, new HashMap<Character, Map>());
                    node = (Map) node.get(c);
                }
            }
            
            if (cnt >= maxVal && cnt > 0) {
                prefix = sb.toString();

                if (cnt > maxVal) {
                    for (int idx = 0; idx < list.size(); idx++) {
                        String str = list.get(idx);
                        if (str.startsWith(prefix) && !str.equals(temp)) {
                            sIdx = idx;
                            answer1 = list.get(sIdx);
                            answer2 = temp;
                            break;
                        }
                    }
                }
                else {
                    for (int idx = 0; idx < list.size() && idx < sIdx; idx++) {
                        String str = list.get(idx);
                        if (str.startsWith(prefix) && !str.equals(temp)) {
                            sIdx = idx;
                            answer1 = list.get(sIdx);
                            answer2 = temp;
                            break;
                        }
                    }
                }

                maxVal = cnt;
            }
        }

        System.out.println(answer1);
        System.out.println(answer2);
        br.close();
    }
}