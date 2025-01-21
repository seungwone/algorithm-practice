import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int answer = 0;
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();

		if ((V - A) % (A - B) == 0) {
			answer = (V - A) / (A - B) + 1;
		} else {
			answer = (V - A) / (A - B) + 2;
		}

		System.out.println(answer);
		sc.close();
    }
}