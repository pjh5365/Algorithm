import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 2; i++) {
			sb.append("@");
		}
		sb.append("\n");
		for (int i = 0; i < N; i++) {
			sb.append("@");
			sb.append(" ".repeat(N));
			sb.append("@").append("\n");
		}
		for (int i = 0; i < N + 2; i++) {
			sb.append("@");
		}
		sb.append("\n");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
