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
			int ret = 0;
			while (N >= 5) {
				ret += N /= 5;
			}
			sb.append(ret).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
