import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while (true) {
			HashMap<Double, ArrayList<String>> h = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			double[] arr = new double[N];
			if (N == 0) {
				break;
			}

			double max = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				double b = Double.parseDouble(st.nextToken());
				if (h.get(b) == null) {
					h.put(b, new ArrayList<>());
					h.get(b).add(a);
				} else {
					h.get(b).add(a);
				}
				arr[i] = b;
				// max = Math.max(max, b);
			}
			Arrays.sort(arr);
			for (String s : h.get(arr[N - 1])) {
				sb.append(s).append(" ");
			}
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
