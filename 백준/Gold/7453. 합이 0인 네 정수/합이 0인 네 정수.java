import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		long[] a = new long[N];
		long[] b = new long[N];
		long[] c = new long[N];
		long[] d = new long[N];
		long[] ab = new long[N * N];
		long[] cd = new long[N * N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Long.parseLong(st.nextToken());
			b[i] = Long.parseLong(st.nextToken());
			c[i] = Long.parseLong(st.nextToken());
			d[i] = Long.parseLong(st.nextToken());
		}

		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ab[index] = a[i] + b[j];
				cd[index] = c[i] + d[j];
				index++;
			}
		}

		Arrays.sort(ab);
		Arrays.sort(cd);

		int sIndex = 0;
		int eIndex = N * N - 1;

		long result = 0;
		while (sIndex < N * N && eIndex >= 0) {
			long tmp = ab[sIndex] + cd[eIndex];
			if (tmp == 0) {
				long sCount = 1;
				long eCount = 1;

				while (sIndex + 1 < N * N && (ab[sIndex] == ab[sIndex + 1])) {
					sIndex++;
					sCount++;
				}
				while (eIndex > 0 && (cd[eIndex] == cd[eIndex - 1])) {
					eIndex--;
					eCount++;
				}
				result += sCount * eCount;
				sIndex++;
			} else if (tmp < 0) {
				sIndex++;
			} else {
				eIndex--;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
