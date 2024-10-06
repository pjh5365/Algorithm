import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (true) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				break;
			}
			sb.append(tmp).append(" is ");
			if (tmp % n != 0) {
				sb.append("NOT ");
			}
			sb.append("a multiple of ").append(n).append(". \n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
