import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ret = 0;
        if (arr[0] + arr[1] > arr[2]) {
            ret = arr[0] + arr[1] + arr[2];
        } else {
            ret = (arr[0] + arr[1]) * 2 - 1;
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
