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
		st = new StringTokenizer(br.readLine());
		int index = 0;
		int sum = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			if (sum >= M) {
				if (sum == M) {
					result++;
				}
				while (index < N && sum >= M) {
					sum -= arr[index];
					index++;
					if (sum == M) {
						result++;
					}
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
