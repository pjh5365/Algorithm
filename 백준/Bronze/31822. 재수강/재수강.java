import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.substring(0, 5).equals(s.substring(0, 5))) {
				cnt++;
			}
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}
