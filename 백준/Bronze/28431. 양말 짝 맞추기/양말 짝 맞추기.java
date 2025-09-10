import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        bw.write(set.toArray()[0] + "");
        bw.flush();
    }
}
