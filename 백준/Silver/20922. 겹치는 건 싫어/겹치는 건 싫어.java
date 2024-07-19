import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] numCount = new int[100001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		int sIndex = 0;
		int count = 0;
		for (int i = sIndex; i < N; i++) {
			if (numCount[arr[i]] < K) {
				numCount[arr[i]]++;
				count++;
				result = Math.max(result, count);
			} else {
				while (sIndex < i && numCount[arr[i]] >= K) {
					numCount[arr[sIndex]]--;
					sIndex++;
					count--;
				}
				numCount[arr[i]]++;
				count++;
				result = Math.max(result, count);
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
