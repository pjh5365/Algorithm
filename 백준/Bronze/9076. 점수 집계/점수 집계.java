import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[5];
			for (int i = 0; i < 5; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			int total = 0;
			for (int i = 1; i < 4; i++) {
				total += arr[i];
			}

			if (arr[3] - arr[1] >= 4) {
				sb.append("KIN").append("\n");
			} else {
				sb.append(total).append("\n");
			}
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
