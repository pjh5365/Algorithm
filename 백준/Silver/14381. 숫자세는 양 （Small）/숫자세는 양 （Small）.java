import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String N = br.readLine();
			int[] arr = new int[10];
			int count = 0;
			boolean fail = false;
			int sum = 0;
			String now = "";
			while (sum != 10) {
				count++;
				sum = 0;
				now = String.valueOf(Integer.parseInt(N) * count);
				// System.out.print("i = " + i);
				// System.out.println(", N = " + N);
				for (int j = 0; j < now.length(); j++) {
					arr[now.charAt(j) - '0'] = 1;
				}
				for (int j = 0; j < 10; j++) {
					sum += arr[j];
				}

				if (count > 1000000) {
					fail = true;
					break;
				}
			}

			if (fail) {
				sb.append("Case #").append(i + 1).append(": INSOMNIA\n");
			} else {
				sb.append("Case #").append(i + 1).append(": ").append(now).append("\n");
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
