import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int fixL = 0;
        int fixO = 0;
        int fixV = 0;
        int fixE = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                fixL++;
            } else if (s.charAt(i) == 'O') {
                fixO++;
            } else if (s.charAt(i) == 'V') {
                fixV++;
            } else if (s.charAt(i) == 'E') {
                fixE++;
            }
        }
        String ret = "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int L = fixL;
            int O = fixO;
            int V = fixV;
            int E = fixE;
            String now = br.readLine();
            for (int idx = 0; idx < now.length(); idx++) {
                if (now.charAt(idx) == 'L') {
                    L++;
                } else if (now.charAt(idx) == 'O') {
                    O++;
                } else if (now.charAt(idx) == 'V') {
                    V++;
                } else if (now.charAt(idx) == 'E') {
                    E++;
                }
            }
            int tmp = ((L+O) * (L+V) * (L+E) * (O+V) * (O+E) * (V+E)) % 100;
            if (max < tmp) {
                max = tmp;
                ret = now;
            } else if (max == tmp) {
                ret = ret.compareTo(now) > 0 ? now : ret;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
