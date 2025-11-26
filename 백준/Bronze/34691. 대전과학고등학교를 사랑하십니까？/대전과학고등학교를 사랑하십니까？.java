import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            if (s.equals("animal")) {
                sb.append("Panthera tigris");
            } else if (s.equals("tree")) {
                sb.append("Pinus densiflora");
            } else {
                sb.append("Forsythia koreana");
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
