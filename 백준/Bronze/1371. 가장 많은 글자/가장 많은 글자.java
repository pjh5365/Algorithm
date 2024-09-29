import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[26];

		String s = "";
		int max = 0;
		while ((s = br.readLine()) != null) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != ' ') {
					arr[s.charAt(i) - 'a']++;
					max = Math.max(arr[s.charAt(i) - 'a'], max);
				}
			}
		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] == max) {
				sb.append((char)('a' + i));
			}
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
