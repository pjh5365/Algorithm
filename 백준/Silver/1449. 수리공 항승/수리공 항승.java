import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int ret = 0;
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > tmp) {
				ret++;
				tmp = arr[i];
				tmp += L - 1;
			}
		}

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
