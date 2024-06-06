import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int index = N - 1;
		while (true) {
			if (index == 0) {
				break;
			}
			if (arr[index] < arr[index - 1]) {
				index--;
			} else {
				break;
			}
		}

		if (index == 0) {
			sb.append("-1");
		} else {
			int find = N - 1;
			for (int i = N - 1; i >= index; i--) {
				if (arr[i] > arr[index - 1]) {
					find = i;
					break;
				}
			}
			int tmp = arr[index - 1];
			arr[index - 1] = arr[find];
			arr[find] = tmp;

			Arrays.sort(arr, index, N);

			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
