import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = 0;
		for (int i = 0; i < 4; i++) {
			S += Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = 0;
		for (int i = 0; i < 4; i++) {
			T += Integer.parseInt(st.nextToken());
		}

		bw.write(String.valueOf(Math.max(S, T)));
		bw.flush();
	}
}
