import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = "WelcomeToSMUPC";
        int tmp = N % s.length();
        if (tmp == 1) {
            System.out.println("W");
        } else if (tmp == 2 || tmp == 7) {
            System.out.println("e");
        } else if (tmp == 3) {
            System.out.println("l");
        } else if (tmp == 4) {
            System.out.println("c");
        } else if (tmp == 5 || tmp == 9) {
            System.out.println("o");
        } else if (tmp == 6) {
            System.out.println("m");
        } else if (tmp == 8) {
            System.out.println("T");
        } else if (tmp == 10) {
            System.out.println("S");
        } else if (tmp == 11) {
            System.out.println("M");
        } else if (tmp == 12) {
            System.out.println("U");
        } else if (tmp == 13) {
            System.out.println("P");
        } else {
            System.out.println("C");
        }
        bw.flush();
    }
}
