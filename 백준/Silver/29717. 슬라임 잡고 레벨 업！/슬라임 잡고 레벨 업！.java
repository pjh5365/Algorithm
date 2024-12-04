import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 등차수열의 합을 이용해서 경험치의 총량을 구하고 이분탐색으로 레벨 탐색하기
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			long exp = (long)N * (2 + (N - 1)) / 2; // N 마리까지 처치하고 얻은 경험치 총량

			long ret  = 1;
			long left = 1;
			long right = N; // 최대 레벨은 N
			while (left <= right) {
				long mid = (left + right) / 2;
				long levelExp = mid * (4 + (mid - 1) * 2) / 2;

				if (levelExp < exp) {
					left = mid + 1;
					ret = Math.max(ret, mid + 1);
				} else if (levelExp > exp) {
					right = mid - 1;
				} else {
					ret = Math.max(ret, mid + 1);
					break;
				}
			}
			sb.append(ret).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
