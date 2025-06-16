import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        Set<Integer> s = new HashSet<>();
        s.add(0);
        for (int i = 1; i <= N; i++) {
            A[i] = A[i - 1] - i;
            if (A[i] < 0 || s.contains(A[i])) {
                A[i] = A[i - 1] + i;
            }
            s.add(A[i]);
        }

        bw.write(A[N] + "");
        bw.flush();
    }
}
