import java.util.*;

class Main {
    static int N, M;
    static int[] result;
    static Set<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];
        set = new HashSet<>();

        dfs(0);
    }

    public static void dfs(int count) {
        if (count == M) {
            for (int e : result) System.out.print(e + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (set.contains(i)) continue;

            result[count] = i;
            set.add(i);
            dfs(count + 1);
            set.remove(i);
        }
    }
}