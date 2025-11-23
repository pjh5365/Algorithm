import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();


        for (int i = 1; i <= s.length(); i++) {
            if (i % 3 == 0) {
                sb.append("..*.");
            } else {
                sb.append("..#.");
            }
            if (i == s.length()) {
                sb.append(".");
            }
        }
        sb.append("\n");
        for (int i = 1; i <= s.length(); i++) {
            if (i % 3 == 0) {
                sb.append(".*.*");
            } else {
                sb.append(".#.#");
            }
            if (i == s.length()) {
                sb.append(".");
            }
        }
        sb.append("\n");
        for (int i = 1; i <= s.length(); i++) {
            if (i % 3 == 0) {
                sb.append("*.").append(s.charAt(i - 1)).append(".").append("*");
            } else {
                if (i == 4 || i == 7 || i == 10 || i == 13) {
                    sb.append(".").append(s.charAt(i - 1)).append(".");
                } else {
                    sb.append("#.").append(s.charAt(i - 1)).append(".");
                }
                if (i == s.length()) {
                    sb.append("#");
                }
            }
        }
        sb.append("\n");
        for (int i = 1; i <= s.length(); i++) {
            if (i % 3 == 0) {
                sb.append(".*.*");
            } else {
                sb.append(".#.#");
            }
            if (i == s.length()) {
                sb.append(".");
            }
        }
        sb.append("\n");
        for (int i = 1; i <= s.length(); i++) {
            if (i % 3 == 0) {
                sb.append("..*.");
            } else {
                sb.append("..#.");
            }
            if (i == s.length()) {
                sb.append(".");
            }
        }
        sb.append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
