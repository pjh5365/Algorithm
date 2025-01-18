import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			sb.append(i).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
