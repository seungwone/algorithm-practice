import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (!map.containsKey(A[i]))
                map.put(A[i], 0);
            map.put(A[i], map.get(A[i]) + 1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = A[i] + A[j];
                
                if ((sum == A[i] && map.get(A[i]) == 1) || (sum == A[j] && map.get(A[j]) == 1))
                    continue;
                if (sum == A[i] && A[i] == A[j] && map.get(A[i]) == 2)
                    continue;

                set.add(sum);
            }
        }

        for (int e : A) {
            if (set.contains(e))
                answer++;
        }

        System.out.println(answer);
        br.close();
    }
}