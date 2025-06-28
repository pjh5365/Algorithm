import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        boolean upper = false;
        boolean lower = false;
        if (set.containsAll(List.of('R', 'O', 'Y', 'G', 'B', 'I', 'V'))) {
            upper = true;
        }
        if (set.containsAll(List.of('r', 'o', 'y', 'g', 'b', 'i', 'v'))) {
            lower = true;
        }

        String ret = "NO!";
        if (upper && lower) {
            ret = "YeS";
        } else if (upper) {
            ret = "YES";
        } else if (lower) {
            ret = "yes";
        }

        bw.write(ret + "");
        bw.flush();
    }
}
