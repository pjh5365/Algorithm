import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int eIndex = 0;

		int result = Integer.MAX_VALUE;
		for (int sIndex = 0; sIndex < N; sIndex++) {
			while (eIndex < N && arr[eIndex] - arr[sIndex] < M) {
				eIndex++;
			}
			if (eIndex == N) {
				break;
			}
			result = Math.min(result, arr[eIndex] - arr[sIndex]);
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
