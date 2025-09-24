import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ret = (int)Math.max(arr[0] * arr[1] / arr[2], arr[0] / arr[1] * arr[2]);

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
