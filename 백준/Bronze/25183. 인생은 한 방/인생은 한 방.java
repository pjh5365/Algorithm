import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int tmp = 1;
		int ret = 0;
		for (int i = 1; i < N; i++) {
			if (s.charAt(i) == s.charAt(i - 1) - 1 || s.charAt(i) == s.charAt(i - 1) + 1) {
				tmp++;
			} else {
				tmp = 1;
			}
			ret = Math.max(ret, tmp);
		}

		if (ret >= 5) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}

		bw.newLine();
		bw.flush();
	}
}
