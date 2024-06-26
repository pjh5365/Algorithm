import java.io.*;
import java.util.*;

// 참고 : https://st-lab.tistory.com/79
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int len = y - x;
			int max = (int)Math.sqrt(len);

			if (max == Math.sqrt(len)) {
				sb.append(max * 2 - 1).append("\n");
			} else if (len <= max * max + max) {
				sb.append(max * 2).append("\n");
			} else {
				sb.append(max * 2 + 1).append("\n");
			}
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
