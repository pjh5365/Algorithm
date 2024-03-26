import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int S = Integer.parseInt(br.readLine());
		while (S > 0) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int input = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for (int i = input - 1; i < N; i += input) {
					if (arr[i] == 1) {
						arr[i] = 0;
					} else {
						arr[i] = 1;
					}
				}
			} else {
				arr[input - 1] = arr[input - 1] == 0 ? 1 : 0;
				int l = input - 2;
				int r = input;
				while (l >= 0 && r < N) {
					if (arr[l] == arr[r]) {
						arr[l] = arr[l] == 0 ? 1 : 0;
						arr[r] = arr[r] == 0 ? 1 : 0;
						l--;
						r++;
					} else {
						break;
					}
				}
			}
			S--;
		}

		for (int i = 0; i < N; i++) {
			if (i != 0 && i % 20 == 0) {
				sb.append("\n");
			}
			sb.append(arr[i]).append(" ");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
