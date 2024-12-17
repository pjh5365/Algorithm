import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();
		String s = br.readLine();
		set.add('C');
		set.add('A');
		set.add('M');
		set.add('B');
		set.add('R');
		set.add('I');
		set.add('D');
		set.add('G');
		set.add('E');
		for (int i = 0; i < s.length(); i++) {
			if (!set.contains(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		sb.append("\n");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
