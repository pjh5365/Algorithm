import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[10][21];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(arr[i], '.');
        }
        while (N-- > 0) {
            String s = br.readLine();
            char c = s.charAt(0);
            int num = Integer.parseInt(s.substring(1));

            arr[c - 'A'][num] = 'o';
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 21; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb + " ");
        bw.flush();
    }
}
