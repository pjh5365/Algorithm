import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		L:
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				int sum = 0;
				for (int l = 0; l < 9; l++) {
					if (l == i || l == j) {
						continue;
					}
					sum += arr[l];
					sb.append(arr[l]).append("\n");
				}
				if (sum == 100) {
					break L;
				} else {
					sb.delete(0, sb.length());
				}
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
