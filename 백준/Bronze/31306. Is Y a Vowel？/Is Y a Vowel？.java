import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		int ret1 = 0;
		int ret2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				ret1++;
				ret2++;
			} else if (s.charAt(i) == 'y') {
				ret2++;
			}
		}

		bw.write(ret1 + " " + ret2);
		bw.flush();
	}
}
