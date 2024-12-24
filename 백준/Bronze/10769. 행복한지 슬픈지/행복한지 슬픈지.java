import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();

		int happyCnt = 0;
		int sadCnt = 0;

		for (int i = 2; i < s.length(); i++) {
			if (s.charAt(i - 2) == ':' && s.charAt(i - 1) == '-') {
				if (s.charAt(i) == ')') {
					happyCnt++;
				} else if (s.charAt(i) == '(') {
					sadCnt++;
				}
			}
		}

		String ret = "";
		if (happyCnt == 0 && sadCnt == 0) {
			ret = "none";
		} else if (happyCnt == sadCnt) {
			ret = "unsure";
		} else if (happyCnt > sadCnt) {
			ret = "happy";
		} else {
			ret = "sad";
		}

		bw.write(ret);
		bw.flush();
	}
}
