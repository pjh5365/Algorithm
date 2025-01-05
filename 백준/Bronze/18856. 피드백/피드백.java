import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		sb.append(N).append("\n");
		for (int i = 1; i < N; i++) {
			sb.append(i).append(" ");
		}
		sb.append("997");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
