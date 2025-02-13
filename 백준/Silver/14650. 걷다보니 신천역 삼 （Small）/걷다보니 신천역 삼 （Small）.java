import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String s;
	static Set<String> set = new HashSet<>();
	static int ret = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		find("1");
		find("2");

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static void find(String s) {
		if (s.length() == N) {
			if (set.contains(s)) {
				return;
			}
			if (Integer.parseInt(s) % 3 == 0) {
				ret++;
				set.add(s);
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			find(s + i);
		}
	}
}
