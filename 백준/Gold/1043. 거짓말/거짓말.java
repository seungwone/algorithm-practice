import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        List<Integer>[] partyPeople = new List[M];
        for (int i = 0; i < M; i++)
            partyPeople[i] = new ArrayList<>();

        temp = br.readLine().split(" ");
        int knownC = Integer.parseInt(temp[0]);
        Set<Integer> knownP = new HashSet<>();
        for (int i = 1; i <= knownC; i++)
            knownP.add(Integer.parseInt(temp[i]));

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            int c = Integer.parseInt(temp[0]);
            for (int j = 1; j <= c; j++)
                partyPeople[i].add(Integer.parseInt(temp[j]));
        }

        boolean[] isKnown = new boolean[M];

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < M; i++) {
                if (isKnown[i])
                    continue;

                List<Integer> li = partyPeople[i];

                boolean isPossible = true;
                for (int e : li) {
                    if (knownP.contains(e)) {
                        isPossible = false;
                    }
                }

                if (!isPossible) {
                    flag = true;
                    isKnown[i] = true;
                    for (int e : li)
                        knownP.add(e);
                }
            }
        }

        int answer = 0;

        for (boolean b : isKnown) {
            if (!b)
                answer++;
        }

        System.out.println(answer);
        br.close();
    }
}