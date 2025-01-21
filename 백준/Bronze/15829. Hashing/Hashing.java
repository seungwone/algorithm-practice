import java.util.*;

class Main {
    public static void main(String[] args) {
        long answer = 0;
		int r = 31;
		int M = 1234567891;

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();

		for (int i = 0; i < n; i++) {
			long a = str.charAt(i) - 'a' + 1;
			long temp = 1;
			for (int j = 0; j < i; j++) {
				temp = (temp * r) % M;
			}
			answer = (answer + (a * temp) % M) % M;
		}

		System.out.println(answer);
		sc.close();
    }
}