import java.io.*;
import java.util.*;

// 참고: https://develop247.tistory.com/595
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dish = new int[d + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int result = 0;
		int count = 0;
		for (int i = 0; i < k; i++) {
			if (dish[arr[i]] == 0) {
				count++;
			}
			dish[arr[i]]++;
		}

		for (int i = 0; i < N; i++) {
			if (dish[c] == 0) {
				result = Math.max(result, count + 1);
			} else {
				result = Math.max(result, count);
			}

			dish[arr[i]]--;
			if (dish[arr[i]] == 0) {
				count--;
			}
			if (dish[arr[(i + k) % N]] == 0) {
				count++;
			}
			dish[arr[(i + k) % N]]++;
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
