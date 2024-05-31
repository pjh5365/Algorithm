import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String s;
		while ((s = br.readLine()) != null) {
			int N = Integer.parseInt(s);
			int mod = 0;
			for (int i = 1; ; i++) {
				mod = (mod * 10 + 1) % N;
				if (mod == 0) {
					sb.append(i).append("\n");
					break;
				}
			}
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
