import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Long.parseLong(br.readLine());
		long ret = 1;
		long cat = 1;
		while (cat < N) {
			cat *= 2;
			ret++;
		}
        if (N == 0) {
            ret = 0;
        }

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
