import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), "/");
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());

		if (K + A < D || D == 0) {
			bw.write("hasu");
		} else {
			bw.write("gosu");
		}
		bw.flush();
	}
}
