import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());

		int result = 1;

		boolean isOk = false;
		int min = Math.min(kim, lim);
		int max = Math.max(kim, lim);
		while (result < N) {
			if (max % 2 == 0 && min + 1 == max) {
				isOk = true;
				break;
			}
			result++;
			if (min % 2 == 0) {
				min /= 2;
			} else {
				min = min / 2 + 1;
			}
			if (max % 2 == 0) {
				max /= 2;
			} else {
				max = max / 2 + 1;
			}
		}

		if (isOk) {
			bw.write(String.valueOf(result));
		} else {
			bw.write(String.valueOf(-1));
		}
		bw.flush();
	}
}
