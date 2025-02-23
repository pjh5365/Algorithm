import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<Integer, Character> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			s = s.toUpperCase();
			int I = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			map.put(I - 1, s.charAt(D - 1));
		}

		for (char i : map.values()) {
			sb.append(i);
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
