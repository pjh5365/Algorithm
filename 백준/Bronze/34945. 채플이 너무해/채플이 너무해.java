import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        if (8 - x <= 2) {
            bw.write("Success!");
        } else {
            bw.write("Oh My God!");
        }
        bw.flush();
    }
}
