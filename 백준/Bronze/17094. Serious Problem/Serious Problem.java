import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String ret;
		int len = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '2') {
				cnt1++;
			} else {
				cnt2++;
			}
		}

		if (cnt1 > cnt2) {
			ret = "2";
		} else if (cnt1 < cnt2) {
			ret = "e";
		} else {
			ret = "yee";
		}

		bw.write(ret);
		bw.flush();
	}
}
