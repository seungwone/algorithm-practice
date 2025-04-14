import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] graph = new int[n + 1];
            int[] isSelected = new int[n + 1];
            
            for (int i = 1; i <= n; i++)
                graph[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (isSelected[i] != 0)
                    continue;

                Set<Integer> isVisited = new HashSet<>();
                List<Integer> list = new ArrayList<>();
                isVisited.add(i);
                list.add(i);
                int next = graph[i];
                while (!isVisited.contains(next) && isSelected[next] == 0) {
                    isVisited.add(next);
                    list.add(next);
                    next = graph[next];
                }

                if (isSelected[next] != 0) {
                    for (int e : list) {
                        if (e == next)
                            break;
                        isSelected[e] = -1;
                    }
                    continue;
                }

                if (i == next) {
                    for (int e : isVisited)
                        isSelected[e] = 1;
                }
                else {
                    int flag = -1;
                    for (int e : list) {
                        if (e == next)
                            flag = 1;
                        isSelected[e] = flag;
                    }
                }
            }

            int answer = 0;
            for (int i = 1; i <= n; i++)
                if (isSelected[i] == -1)
                    answer++;
            
            sb.append(answer + "\n");
        }

        System.out.print(sb);
        br.close();
    }
}