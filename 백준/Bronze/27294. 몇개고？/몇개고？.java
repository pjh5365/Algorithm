import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		if (T >= 12 && T <= 16 && S == 0)
			bw.write(String.valueOf(320));
		else
			bw.write(String.valueOf(280));
		bw.flush();
	}
}
