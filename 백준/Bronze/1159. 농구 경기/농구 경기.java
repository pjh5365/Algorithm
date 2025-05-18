import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        while (N-- > 0) {
            String s = br.readLine();
            map.put(s.charAt(0), map.getOrDefault(s.charAt(0), 0) + 1);
        }

        for (Character key : map.keySet()) {
            if (map.get(key) >= 5) {
                sb.append(key);
            }
        }
        if (sb.length() == 0) {
            sb.append("PREDAJA");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
