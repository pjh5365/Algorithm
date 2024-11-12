import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append("@@@@@");
			}
			sb.append("\n");
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < N; k++) {
					sb.append("@");
				}
				sb.append("\n");
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
