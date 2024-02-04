import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			sb.append(A + B).append("\n");
			T--;
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
