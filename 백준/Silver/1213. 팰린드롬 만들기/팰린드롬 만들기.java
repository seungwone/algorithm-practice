import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphaCount = new int[26];
        int middleIdx = -1;
        String str = sc.next();
        int strLength = str.length();
        char[] answer = new char[strLength];
        for (char c : str.toCharArray()) alphaCount[c - 'A']++;

        for (int i = 0; i < 26; i++) {
            if (alphaCount[i] % 2 != 0) {
                if (strLength % 2 == 0 || middleIdx != -1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }

                middleIdx = i;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (alphaCount[i] < 2) continue;

            for (int j = 0; j < alphaCount[i] / 2; j++) {
                answer[count] = (char) ('A' + i);
                answer[(strLength-1) - count] = (char) ('A' + i);
                count++;
            }
        }

        if (strLength % 2 != 0) answer[count] = (char) ('A' + middleIdx);

        for (char c : answer) System.out.print(c);
        System.out.println();
    }
}