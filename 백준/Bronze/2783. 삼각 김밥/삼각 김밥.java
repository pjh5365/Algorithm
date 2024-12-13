import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		double ret = (double)X / Y;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ret = Math.min(ret, (double)a / b);
		}

		bw.write(String.valueOf(ret * 1000));
		bw.flush();
	}
}
