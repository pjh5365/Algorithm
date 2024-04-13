import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		int index = 0;
		while (N > 0) {
			while (st.hasMoreTokens()) {
				String now = st.nextToken();
				StringBuilder tmp = new StringBuilder();
				if (now.length() == 1) {
					arr[index++] = Long.parseLong(now);
				} else {
					for (int i = now.length() - 1; i >= 0; i--) {
						tmp.append(now.charAt(i));
					}
					arr[index++] = Long.parseLong(tmp.toString());
				}
				N--;
			}
			if (N > 0) {
				st = new StringTokenizer(br.readLine());
			}
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
