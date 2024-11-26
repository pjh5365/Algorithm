import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += check(i);
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
	}

	static int check(int now) {
		String s = String.valueOf(now);
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
		}
		if (s.length() == 1) {
			return 1;
		}
		int tmp = arr[1] - arr[0];

		for (int i = 2; i < s.length(); i++) {
			if (arr[i] - arr[i - 1] != tmp) {
				return 0;
			}
		}
		return 1;
	}
}
