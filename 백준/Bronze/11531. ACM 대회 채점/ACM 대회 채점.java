import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = "";
		int[] count = new int[26];
		int ret1 = 0;
		int ret2 = 0;
		while (true) {
			s = br.readLine();
			if (s.equals("-1")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			char b = st.nextToken().charAt(0);
			String c = st.nextToken();
			if (c.equals("right")) {
				ret1++;
				ret2 += a + count[b - 'A'] * 20;
			} else {
				count[b - 'A']++;
			}
		}

		bw.write(ret1 + " " + ret2);
		bw.newLine();
		bw.flush();
	}
}
