import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int diff = 10;
		String s = null;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int inputDiff = Integer.parseInt(st.nextToken());

			if (inputDiff < diff) {
				diff = inputDiff;
				s = input;
			}
		}

		bw.write(String.valueOf(s));
		bw.flush();
	}
}
