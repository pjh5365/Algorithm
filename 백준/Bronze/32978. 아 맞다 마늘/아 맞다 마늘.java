import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Set<String> s = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s.add(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			s.remove(st.nextToken());
		}
		
		bw.write(String.valueOf(s.toArray()[0]));
		bw.flush();
	}
}
