import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();

			while (st.hasMoreElements()) {
				sb.append(st.nextToken()).append(" ");
			}
			sb.append(s1).append(" ").append(s2).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
