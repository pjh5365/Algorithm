import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		arr[0] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		// 각 위치별 이동거리 구하기
		int[] tmp = new int[N];
		for (int i = 0; i < N; i++) {
			tmp[i] = arr[i + 1] - arr[i];
		}

		// 이동거리간 최대공약수 구하기
		int result = tmp[0];
		for (int i = 0; i < N - 1; i++) {
			result = gcd(result, tmp[i + 1]);
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
