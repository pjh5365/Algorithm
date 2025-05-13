import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        if (s.startsWith("555")) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        
        bw.flush();
    }
}
