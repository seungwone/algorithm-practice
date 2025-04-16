import java.io.*;
import java.util.*;

class Main {
    static List<Integer[]> list;
    static int[][] sudoku;
    static boolean[][] row;
    static boolean[][] col;
    static boolean[][] part;
    static boolean isFinished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[10][10];
        row = new boolean[10][10];
        col = new boolean[10][10];
        part = new boolean[10][10];
        list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= 9; j++) {
                int val = temp.charAt(j - 1) - '0';
                if (val == 0) {
                    list.add(new Integer[] {i, j});
                    continue;
                }

                sudoku[i][j] = val;
                row[i][val] = true;
                col[j][val] = true;

                int idx = 0;
                if (i <= 3)
                    idx = 1;
                else if (i <= 6)
                    idx = 4;
                else 
                    idx = 7;

                if (j <= 3)
                    idx += 0;
                else if (j <= 6)
                    idx += 1;
                else
                    idx += 2;

                part[idx][val] = true;
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static void dfs(int cnt) {
        if (cnt == list.size()) {
            isFinished = true;
            return;
        }

        Integer[] ele = list.get(cnt);
        int curI = ele[0];
        int curJ = ele[1];
        int partIdx = 0;
        if (curI <= 3)
            partIdx = 1;
        else if (curI <= 6)
            partIdx = 4;
        else 
            partIdx = 7;
        if (curJ <= 3)
            partIdx += 0;
        else if (curJ <= 6)
            partIdx += 1;
        else
            partIdx += 2;
        
        for (int n = 1; n <= 9; n++) {
            if (row[curI][n] == true || col[curJ][n] == true || part[partIdx][n] == true)
                continue;
            row[curI][n] = true;
            col[curJ][n] = true;
            part[partIdx][n] = true;
            sudoku[curI][curJ] = n;
            dfs(cnt + 1);
            if (isFinished)
                return;
            // 원복
            row[curI][n] = false;
            col[curJ][n] = false;
            part[partIdx][n] = false;
        }
    }
}