import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			int now = s.charAt(i) - '0';
			ret += (int)Math.pow(now, 5);
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
