import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int ret = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			int sIndex = 0;
			int eIndex = N - 1;

			while (sIndex < eIndex) {
				int sum = arr[sIndex] + arr[eIndex];
				if (sum == arr[i]) {
					if (sIndex != i && eIndex != i) {
						ret++;
						break;
					} else if (sIndex == i) {
						sIndex++;
					} else {
						eIndex--;
					}
				} else if (sum < arr[i]) {
					sIndex++;
				}
				else {
					eIndex--;
				}
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
