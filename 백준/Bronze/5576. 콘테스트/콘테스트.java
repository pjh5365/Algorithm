import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] A = new int[10];
        int[] B = new int[10];
        for (int i = 0; i < 10; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 10; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int retA = A[7] + A[8] + A[9];
        int retB = B[7] + B[8] + B[9];

        bw.write(retA + " " + retB);
        bw.flush();
    }
}
