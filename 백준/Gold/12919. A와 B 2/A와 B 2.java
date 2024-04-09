import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();
		String T = br.readLine();

		int result = 0;
		result += find(S, T);

		if (result > 1) {
			result = 1;
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}

	static int find(String S, String T) {
		if (S.length() == T.length()) {
			return S.equals(T) ? 1 : 0;
		}
		int result = 0;
		if (T.charAt(T.length() - 1) == 'A') {
			result += find(S, T.substring(0, T.length() - 1));
		}
		if (T.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(T.substring(1));
			sb.reverse();
			result += find(S, sb.toString());
		}
		return result;
	}
}
