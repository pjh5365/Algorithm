import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int i = 2;
		while (true) {
			String s = br.readLine();
			if (s.equals("Was it a cat I saw?")) {
				break;
			}
			for (int j = 0; j < s.length(); j += i) {
				sb.append(s.charAt(j));
			}
			sb.append("\n");
			i++;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
