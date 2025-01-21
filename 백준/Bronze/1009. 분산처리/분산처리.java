import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int answer = 1;

			for (int i = 0; i < b; i++) {
				answer = (answer * a) % 10;

				if (answer == 0) {
					answer = 10;
				}
			}

			System.out.println(answer);
		}
		sc.close();
    }
}