import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int sIndex = 0;
		int count = 0;
		int sum = 0;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			count++;
			while (sum - arr[sIndex] >= S) {
				sum -= arr[sIndex];
				sIndex++;
				count--;
			}
			if (sum >= S) {
				result = Math.min(result, count);
			}
		}
		if (result > 100000) {
			result = 0;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
