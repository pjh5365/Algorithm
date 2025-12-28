import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][N]; // 0 -> 빨간배열, 1 -> 파란배열
        int idx = 0; // 배열 인덱스

        String s = br.readLine();
        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == 'R') {
                arr[0][idx]++;
                if (s.charAt(i) != s.charAt(i + 1)) { // 다른 배열이라면
                    idx++;
                }
            } else {
                arr[1][idx]++;
                if (s.charAt(i) != s.charAt(i + 1)) { // 다른 배열이라면
                    idx++;
                }
            }
        }
        if (s.charAt(N - 1) == 'R') {
            arr[0][idx]++;
        } else {
            arr[1][idx]++;
        }

        int[] ret = new int[6];
        for (int i = 1; i <= idx; i++) { // 빨간색이 0번에 있을때
            ret[0] += arr[0][i];
        }
        for (int i = 0; i < idx; i++) { // 빨간색이 마지막에 있을때
            ret[1] += arr[0][i];
        }
        for (int i = 0; i <= idx; i++) { // 빨간색이 모두 중앙에 있을때
            ret[2] += arr[0][i];
        }
        for (int i = 1; i <= idx; i++) { // 파란색이 0번에 있을때
            ret[3] += arr[1][i];
        }
        for (int i = 0; i < idx; i++) { // 파란색이 마지막에 있을때
            ret[4] += arr[1][i];
        }
        for (int i = 0; i <= idx; i++) { // 파란색이 모두 중앙에 있을때
            ret[5] += arr[1][i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            min = Math.min(min, ret[i]);
        }

        bw.write(min + "");
        bw.flush();
    }
}
