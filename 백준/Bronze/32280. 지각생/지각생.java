import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int idx = 0;
        String tTime = "";
        int ret = 0;
        for (int i = 0; i < N + 1; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String a = st.nextToken();
            String b = st.nextToken();

            if (b.equals("teacher")) {
                tTime = a;
            } else {
                arr[idx++] = a;
            }
        }
        String time = br.readLine();
        for (int i = 0; i < N; i++) {
            if (arr[i].compareTo(time) >= 0&& arr[i].compareTo(tTime) >= 0) {
                ret++;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
