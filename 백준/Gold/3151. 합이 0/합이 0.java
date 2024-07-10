import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long result = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i] > 0) { // 0보다 큰 경우는 계산할 필요가 없다.
				break;
			}
			int sIndex = i + 1;
			int eIndex = N - 1;

			while (sIndex < eIndex) {
				int sum = arr[i] + arr[sIndex] + arr[eIndex];

				if (sum == 0) {
					int sSize = 1; // 시작점과 같은 숫자의 개수
					int eSize = 1; // 끝점과 같은 숫자의 개수

					if (arr[sIndex] == arr[eIndex]) { // 시작점부터 끝점까지 모두 같다면
						int tmp = eIndex - sIndex + 1;
						result += (long)tmp * (tmp - 1) / 2;
						break;
					}
					while (arr[sIndex] == arr[sIndex + 1]) {
						sSize++;
						sIndex++;
					}
					while (arr[eIndex] == arr[eIndex - 1]) {
						eSize++;
						eIndex--;
					}
					result += (long)sSize * eSize;
				}

				if (sum > 0) {
					eIndex--;
				} else {
					sIndex++;
				}
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
