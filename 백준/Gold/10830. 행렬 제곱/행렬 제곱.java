import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] ret = pow(arr, B);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ret[i][j]).append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static int[][] pow(int[][] A, long B) {
        if (B == 1) {
            return A;
        }

        int[][] ret = pow(A, B / 2);
        ret = multi(ret, ret);

        if (B % 2 == 1) {
            ret = multi(ret, arr);
        }
        return ret;
    }

    static int[][] multi(int[][] A, int[][] B) {
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[i][j] += A[i][k] * B[k][j];
                    arr[i][j] %=  1000;
                }
            }
        }

        return arr;
    }
}
