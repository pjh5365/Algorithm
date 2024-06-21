import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] arr = new boolean[N + 1];
		int count = 0;
		int result = 0;
		L:
		for (int i = 2; i <= N; i++) {
			if (!arr[i]) {
				for (int j = i; j <= N; j += i) {
					if (!arr[j]) {
						arr[j] = true;
						count++;
						if (count == K) {
							result = j;
							break L;
						}
					}
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
