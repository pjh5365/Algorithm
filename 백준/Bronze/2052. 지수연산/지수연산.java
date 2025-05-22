import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        BigDecimal ret = new BigDecimal(Math.pow(0.5, N));
        System.out.printf("%." + N + "f\n", ret);

        bw.flush();
    }
}
