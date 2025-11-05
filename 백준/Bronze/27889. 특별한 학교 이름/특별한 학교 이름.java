import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String ret = "";
        if (s.equals("NLCS")) {
            ret = "North London Collegiate School";
        } else if (s.equals("BHA")) {
            ret = "Branksome Hall Asia";
        } else if (s.equals("KIS")) {
            ret = "Korea International School";
        } else {
            ret = "St. Johnsbury Academy";
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
