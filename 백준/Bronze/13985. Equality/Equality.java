import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int a = s.charAt(0) - '0';
		int b = s.charAt(4) - '0';
		int c = s.charAt(8) - '0';

		if (a + b == c) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}
		bw.flush();
	}
}
