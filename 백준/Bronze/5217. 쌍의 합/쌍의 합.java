import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T != 0) {
			int n = Integer.parseInt(br.readLine());

			sb.append("Pairs for ").append(n).append(": ");
			int i = 1;
			while (true) {
				if (n - i <= i) {
					break;
				}
				sb.append(i).append(" ").append(n - i);
				i++;
				if (n - i > i)
					sb.append(", ");
			}
			sb.append("\n");
			T--;
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
