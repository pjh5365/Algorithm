import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] order = new int[6];
		for (int i = 0; i < 6; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int tShirt = 0;
		for (int i = 0; i < 6; i++) {
			while (order[i] > 0) {
				tShirt++;
				order[i] -= T;
			}
		}

		sb.append(tShirt).append("\n");
		sb.append(N / P).append(" ").append(N % P).append("\n");

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
