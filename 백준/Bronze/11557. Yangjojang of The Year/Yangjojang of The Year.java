import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			HashMap<Integer, String> m = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				m.put(b, a);
				arr[i] = b;
			}
			Arrays.sort(arr);
			sb.append(m.get(arr[N - 1])).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
