import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();

        if (!A.equals("null")) {
            sb.append(A.equals(B)).append("\n");
            if (!B.equals("null")) {
                sb.append(A.equalsIgnoreCase(B));
            } else {
                sb.append("false");
            }
        } else {
            sb.append("NullPointerException").append("\n");
            sb.append("NullPointerException").append("\n");
        }

        bw.write(sb + "\n");
        bw.flush();
    }
}
