import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<Character> set = new HashSet<>(List.of('M', 'O', 'B', 'I', 'S'));
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			set.remove(s.charAt(i));
		}

		if (set.isEmpty()) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}

		bw.flush();
	}
}
