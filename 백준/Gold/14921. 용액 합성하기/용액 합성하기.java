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

		int sIndex = 0;
		int eIndex = N - 1;

		int result = Integer.MAX_VALUE;
		while (sIndex < eIndex) {
			int tmp = arr[sIndex] + arr[eIndex];
			if (Math.abs(result) > Math.abs(tmp)) {
				result = tmp;
			}

			if (tmp < 0) {
				sIndex++;
			} else {
				eIndex--;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
