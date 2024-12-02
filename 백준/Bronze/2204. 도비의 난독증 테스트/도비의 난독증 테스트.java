import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			Map<String, String> map = new HashMap<>();
			String[] s = new String[n];
			for (int i = 0; i < n; i++) {
				String get = br.readLine();
				s[i] = get.toLowerCase();
				map.put(s[i], get);
			}
			Arrays.sort(s);
			sb.append(map.get(s[0])).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
