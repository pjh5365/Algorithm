import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int team1 = 0;
		int team2 = 0;
		int A = 0;
		int B = 0;
		int before = 0;

		while (N > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			int min = Integer.parseInt(b.substring(0, 2));
			int sec = Integer.parseInt(b.substring(3));

			int tmp = min * 60 + sec;
			if (A > B) {
				team1 += tmp - before;
			} else if (A < B) {
				team2 += tmp - before;
			}

			if (a == 1) {
				A++;
			} else {
				B++;
			}
			before = tmp;
			N--;
		}
		if (A > B) {
			team1 += 2880 - before;
		} else if (A < B) {
			team2 += 2880 - before;
		}

		if (team1 / 60 < 10) {
			sb.append("0").append(team1 / 60);
		} else {
			sb.append(team1 / 60);
		}
		if (team1 % 60 < 10) {
			sb.append(":0").append(team1 % 60);
		} else {
			sb.append(":").append(team1 % 60);
		}
		sb.append("\n");
		if (team2 / 60 < 10) {
			sb.append("0").append(team2 / 60);
		} else {
			sb.append(team2 / 60);
		}
		if (team2 % 60 < 10) {
			sb.append(":0").append(team2 % 60);
		} else {
			sb.append(":").append(team2 % 60);
		}
		sb.append("\n");

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
