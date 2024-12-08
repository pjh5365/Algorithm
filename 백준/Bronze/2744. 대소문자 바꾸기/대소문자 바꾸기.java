import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				sb.append((char)(s.charAt(i) + 32));
			} else {
				sb.append((char)(s.charAt(i) - 32));
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
