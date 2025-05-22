import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(b / (a + 1)).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
