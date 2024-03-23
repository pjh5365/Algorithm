import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char P = st.nextToken().charAt(0);

		HashSet<String> set = new HashSet<>();
		int result;
		int max = 0;
		if (P == 'Y') {
			max = 2;
		} else if (P == 'F') {
			max = 3;
		} else if (P == 'O') {
			max = 4;
		}
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			set.add(input);
		}

		result = set.size() / (max - 1);

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
