import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        Set<String> noListen = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            noListen.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (noListen.contains(str)) 
                answer.add(str);
        }
        
        sb.append(answer.size() + "\n");
        Collections.sort(answer);
        for (String s : answer)
            sb.append(s + "\n");

        System.out.println(sb);
        br.close();
    }
}