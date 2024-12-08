import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 29197 - 정점의 기울기가 같다면 원점에서 볼 수 있는건 하나밖에 없다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<Double> s = new HashSet<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			double tmp = (double)x / y;
			s.add(tmp);
		}
		bw.write(String.valueOf(s.size()));
		bw.flush();
	}
}
