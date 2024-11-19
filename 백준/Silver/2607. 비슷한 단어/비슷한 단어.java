import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int ret = 0;
		String word = br.readLine();
		for (int i = 1; i < N; i++) {
			String s = br.readLine();
			int[] a = new int[26];
			for (int j = 0; j < word.length(); j++) {
				a[word.charAt(j) - 'A']++;
			}
			int cnt = 0;
			for (int j = 0; j < s.length(); j++) {
				if (a[s.charAt(j) - 'A'] > 0) { // 같은 문자를 발견
					cnt++;
					a[s.charAt(j) - 'A']--;
				}
			}

			// 같은 단어이거나 한글자만 다름
			if (word.length() == s.length() && (word.length() == cnt || word.length() - 1 == cnt)) {
				ret++;
			} else if (word.length() == s.length() - 1 && s.length() - 1 == cnt) {
				// 입력받은 문자열에서 하나 제거
				ret++;
			} else if (word.length() == s.length() + 1 && s.length() == cnt) {
				// 원래 문자열에서 하나 추가
				ret++;
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
