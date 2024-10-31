import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s.equals("EOI")) {
				break;
			}
			if (s.toLowerCase().contains("nemo")) {
				sb.append("Found").append("\n");
			} else {
				sb.append("Missing").append("\n");
			}
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
