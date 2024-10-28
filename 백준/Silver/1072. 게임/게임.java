import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = (int)(((double)y *100) / (double)x);

		int tmp = z;
		int ret = -1;
		int l = 0;
		int r = 1000000000;

		while (l <= r) {
			int m = (l + r) / 2;

			tmp = (int)(((double)(y + m) *100) / (double)(x + m));
			if (tmp != z) {
				ret = m;
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
