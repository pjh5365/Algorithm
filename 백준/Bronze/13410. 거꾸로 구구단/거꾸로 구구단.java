import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ret = 0;
		for (int i = 1; i <= K; i++) {
			StringBuilder sb = new StringBuilder(String.valueOf(N * i));
			sb.reverse();
			ret = Math.max(ret, Integer.parseInt(String.valueOf(sb)));
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
