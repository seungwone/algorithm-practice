import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i])
                continue;

            int j = i;
            while (i * j <= N) {
                isPrime[i * j] = false;
                j++;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        int sum = primes.get(0);
        int i = 0;
        int j = 0;
        int answer = 0;

        if (sum == N)
            answer++;

        while (i <= j && j < primes.size()) {
            if (sum >= N) {
                sum -= primes.get(i++);
            }
            else {
                j++;
                if (j >= primes.size())
                    break;
                sum += primes.get(j);
            }

            if (sum == N)
                answer++;
        }

        System.out.println(answer);
        br.close();
    }
}