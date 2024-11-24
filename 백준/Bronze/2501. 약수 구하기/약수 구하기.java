import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int ret = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				cnt++;
				if (cnt == K) {
					ret = i;
					break;
				}
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
