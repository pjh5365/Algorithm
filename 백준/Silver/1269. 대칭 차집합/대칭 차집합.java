import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> a1 = new HashSet<>();
        Set<Integer> a2 = new HashSet<>();
        Set<Integer> b1 = new HashSet<>();
        Set<Integer> b2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int now = Integer.parseInt(st.nextToken());
            a1.add(now);
            a2.add(now);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int now = Integer.parseInt(st.nextToken());
            b1.add(now);
            b2.add(now);
        }

        a1.removeAll(b1);
        b2.removeAll(a2);

        int ret = a1.size() + b2.size();

        bw.write(ret + "");
        bw.flush();
    }
}
