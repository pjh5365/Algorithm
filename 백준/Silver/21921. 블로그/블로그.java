import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int count = 1;
		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += arr[i];
		}
		max = sum;
		for (int i = X; i < N; i++) {
			sum += arr[i];
			sum -= arr[i - X];
			if (max < sum) {
				max = sum;
				count = 1;
			} else if (max == sum) {
				count++;
			}
		}

		if (max == 0) {
			sb.append("SAD").append("\n");
		} else {
			sb.append(max).append("\n");
			sb.append(count).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
