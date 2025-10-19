import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ret = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                set = new HashSet<>();
            } else {
                if (!set.contains(s)) {
                    set.add(s);
                    ret++;
                }
            }
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
