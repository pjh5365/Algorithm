import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int ret = 0;
		for (int i = 1; i <= N; i++) {
			if (find(i, N)) {
				ret = i;
				break;
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static boolean find(int num, int N) {
		String s = String.valueOf(num);
		int[] arr = new int[s.length()];
		int sum = num;
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
			sum += arr[i];
		}
		return sum == N;
	}
}
