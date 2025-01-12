import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int B = Integer.parseInt(br.readLine());

		int P = 5 * B - 400;
		sb.append(P).append("\n");
		if (100 > P) {
			sb.append(1).append("\n");
		} else if (100 < P) {
			sb.append(-1).append("\n");
		} else {
			sb.append(0).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
