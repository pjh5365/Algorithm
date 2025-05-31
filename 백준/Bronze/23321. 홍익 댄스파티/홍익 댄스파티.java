import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] before = new String[5];
        for (int i = 0; i < 5; i++) {
            before[i] = br.readLine();
        }

        String[] after = new String[before[0].length()];
        for (int i = 0; i < before[0].length(); i++) {
            char[] now = new char[5];
            for (int j = 0; j < 5; j++) {
                now[j] = before[j].charAt(i);
            }
            after[i] = new String(now);
        }

        for (int i = 0; i < before[0].length(); i++) {
            if (after[i].equals(".omln")) {
                after[i] = "owln.";
            } else if (after[i].equals("owln.")) {
                after[i] = ".omln";
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < after.length; j++) {
                sb.append(after[j].charAt(i));
            }
            sb.append("\n");
        }


        bw.write(sb + "");
        bw.flush();
    }
}
