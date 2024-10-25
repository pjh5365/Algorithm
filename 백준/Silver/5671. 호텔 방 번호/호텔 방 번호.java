import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String s;
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int ret = 0;
			for (int i = N; i <= M; i++) {
				int[] arr = new int[10];
				String a = String.valueOf(i);
				for (int j = 0; j < a.length(); j++) {
					arr[a.charAt(j) - '0']++;
					if (arr[a.charAt(j) - '0'] >= 2) {
						ret++;
						break;
					}
				}
			}
			sb.append(M - N + 1 - ret).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
