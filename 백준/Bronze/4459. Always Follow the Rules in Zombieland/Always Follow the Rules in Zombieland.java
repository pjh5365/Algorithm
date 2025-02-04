import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int q = Integer.parseInt(br.readLine());
		Map<Integer, String> map = new HashMap<>();
		for (int i = 1; i <= q; i++) {
			map.put(i, br.readLine());
		}
		int r = Integer.parseInt(br.readLine());
		for (int i = 0; i < r; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("Rule ").append(n).append(": ").append(map.getOrDefault(n, "No such rule")).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
