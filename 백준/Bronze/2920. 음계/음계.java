import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] x = new int[st.countTokens()];
		int index = 0;
		while (st.hasMoreTokens()) {
			x[index++] = Integer.parseInt(st.nextToken());
		}
		int value = x[0];
		String result = "";
		if (value < x[1]) {
			value = x[1];
			result = "ascending";
			for (int i = 2; i < x.length; i++) {
				if (value >= x[i]) {
					result = "mixed";
					break;
				}
				value = x[i];
			}
		} else if (value > x[1]) {
			value = x[1];
			result = "descending";
			for (int i = 2; i < x.length; i++) {
				if (value <= x[i]) {
					result = "mixed";
					break;
				}
				value = x[i];
			}
		}
		bw.write(result);
		bw.flush();
	}
}
