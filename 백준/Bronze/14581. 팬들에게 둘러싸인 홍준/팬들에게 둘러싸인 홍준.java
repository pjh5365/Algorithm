import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		sb.append(":fan::fan::fan:\n" + ":fan::").append(s).append("::fan:\n").append(":fan::fan::fan:");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
