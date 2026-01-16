import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger num = new BigInteger(br.readLine(), 2);
        String ret = num.toString(8);

        bw.write(ret + "");
        bw.flush();
    }
}
