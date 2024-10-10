import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			sb.append("Case #").append(i + 1).append(": ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> s = new ArrayList<>();
			while (st.hasMoreTokens()) {
				s.add(st.nextToken());
			}
			for (int j = s.size() - 1; j >= 0; j--) {
				sb.append(s.get(j)).append(" ");
			}
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
