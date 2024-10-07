import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());

			if (M == 0 && F == 0) {
				break;
			}

			sb.append(M + F).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
