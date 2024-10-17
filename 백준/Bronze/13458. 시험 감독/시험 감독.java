import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long ret = 0;
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			ret++;
			arr[i] -= A;
			if (arr[i] <= 0) {
				continue;
			}
			ret += arr[i] / B;
			if (arr[i] % B != 0) {
				ret++;
			}
		}

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
