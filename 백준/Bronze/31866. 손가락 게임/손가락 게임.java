import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ret = "";
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean flag1 = false
                ;
        boolean flag2 = false
                ;

        if (A == 0 || A == 2 || A == 5) {
            flag1 = true;
        }
        if (B == 0 || B == 2 || B == 5) {
            flag2 = true;
        }

        if (flag1 && flag2) {
            if (A == 0) {
                if (B == 0) {
                    ret = "=";
                } else if (B == 2) {
                    ret = ">";
                } else {
                    ret = "<";
                }
            } else if (A == 2) {
                if (B == 0) {
                    ret = "<";
                } else if (B == 2) {
                    ret = "=";
                } else {
                    ret = ">";
                }
            } else if (A == 5) {
                if (B == 0) {
                    ret = ">";
                } else if (B == 2) {
                    ret = "<";
                } else {
                    ret = "=";
                }
            }
        } else {
            if (flag1 == flag2) {
                ret = "=";
            } else if (flag2) {
                ret = "<";
            } else {
                ret = ">";
            }
        }


        bw.write(ret);
        bw.flush();
    }
}
