import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] table = new int[N + 1];
        Set<Integer> answerSet = new HashSet<>();

        for (int i = 1; i <= N; i++)
            table[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int start = i;
            int idx = i;
            boolean[] isVisited = new boolean[N + 1];
            isVisited[idx] = true;
            Set<Integer> temp = new HashSet<>();
            temp.add(idx);
            while (!isVisited[table[idx]]) {
                idx = table[idx];
                isVisited[idx] = true;
                temp.add(idx);
            }

            if (start != table[idx])
                continue;
            
            answerSet.addAll(temp);
        }

        List<Integer> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        
        sb.append(answer.size() + "\n");
        for (int e : answer)
            sb.append(e + "\n");
        
        System.out.println(sb);
        br.close();
    }
}