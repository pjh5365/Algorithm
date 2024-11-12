import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		String[] s = new String[N];
		for (int i = 0; i < N; i++) {
			s[i] = br.readLine();
		}

		int max = 0;
		sb.append(s[0]).append("\n").append(s[1]).append("\n");

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int minLen = Math.min(s[i].length(), s[j].length());
				int cnt = 0;
				for (int k = 0; k < minLen; k++) {
					if (s[i].charAt(k) == s[j].charAt(k)) {
						cnt++;
					} else {
						break;
					}
				}
				if (max < cnt) {
					sb.delete(0, sb.length());
					max = cnt;
					sb.append(s[i]).append("\n").append(s[j]).append("\n");
				}
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
