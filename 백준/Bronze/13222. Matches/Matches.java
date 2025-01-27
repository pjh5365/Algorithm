import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int L = (int)Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2));

		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine());
			if (len <= Math.max(W, Math.max(L, H))) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
