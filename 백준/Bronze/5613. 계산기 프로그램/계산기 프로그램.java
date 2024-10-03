import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ret = Integer.parseInt(br.readLine());
		int tmp = 0;
		while (true) {
			String input = br.readLine();
			if (input.equals("=")) {
				break;
			} else if (input.equals("+")) {
				tmp = Integer.parseInt(br.readLine());
				ret += tmp;
			} else if (input.equals("-")) {
				tmp = Integer.parseInt(br.readLine());
				ret -= tmp;
			} else if (input.equals("*")) {
				tmp = Integer.parseInt(br.readLine());
				ret *= tmp;
			} else if (input.equals("/")) {
				tmp = Integer.parseInt(br.readLine());
				ret /= tmp;
			}
		}

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
