import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		boolean check = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'S' || s.charAt(i) == 'H'
					|| s.charAt(i) == 'Z' || s.charAt(i) == 'X' || s.charAt(i) == 'N') {
				check = true;
			} else {
				check = false;
			}
		}

		if (check) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}

		bw.flush();
	}
}
