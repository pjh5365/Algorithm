import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<String> s = new HashSet<>();
		String ret = "";
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			s.add(input);
		}
		if (s.contains("anj")) {
			ret = "뭐야;";
		} else {
			ret = "뭐야?";
		}

		bw.write(ret);
		bw.flush();
	}
}
