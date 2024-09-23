import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		sb.append(A + B - C).append("\n");
		sb.append(Integer.parseInt("" + A + B) - C).append("\n");


		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
