import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();

		int cnt = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.substring(i).startsWith(s2)) {
				cnt++;
				i += s2.length() - 1;
			}
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}
