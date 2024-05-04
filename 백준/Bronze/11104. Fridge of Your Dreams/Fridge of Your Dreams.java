import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		while (n > 0) {
			int result = Integer.parseInt(br.readLine(), 2);
			sb.append(result).append("\n");
			n--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
