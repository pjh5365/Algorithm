import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long R = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        long ret = (long)(Math.ceil((double)R / N) * Math.ceil((double)C / N));

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
