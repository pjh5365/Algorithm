import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T > 0) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 2; i <= N; i++) {
				if (N % i == 0) {
					int count = 1;
					N /= i;
					while (N % i == 0) {
						count++;
						N /= i;
					}
					sb.append(i).append(" ").append(count).append("\n");
				}
			}
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
