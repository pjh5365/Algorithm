import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long digit = 1; // 자리수
		long numSize = 9; // 자리수별 숫자개수
		long result = 0;

		while (k > digit * numSize) { // 다음 자리수에 있다면
			k -= digit * numSize;
			result += numSize;
			digit++;
			numSize *= 10;
		}

		result = (result + 1) + ((k - 1) / digit);

		if (result <= N) {
			bw.write(String.valueOf(String.valueOf(result).charAt((int)((k - 1) % digit))));
		} else {
			bw.write(String.valueOf(-1));
		}
		bw.flush();
	}
}
