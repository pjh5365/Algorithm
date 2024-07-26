import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append("  ___  ___  ___\n"
				+ "  | |__| |__| |\n"
				+ "  |           |\n"
				+ "   \\_________/\n"
				+ "    \\_______/\n"
				+ "     |     |\n"
				+ "     |     |\n"
				+ "     |     |\n"
				+ "     |     |\n"
				+ "     |_____|\n"
				+ "  __/       \\__\n"
				+ " /             \\\n"
				+ "/_______________\\");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
