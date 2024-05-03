import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 1) {
					sum += i;
				}
			}
			sb.append(sum).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
