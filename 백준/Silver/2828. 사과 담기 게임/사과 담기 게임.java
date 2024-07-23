import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());

		int sIndex = 1;
		int eIndex = M;
		int result = 0;
		for (int i = 0; i < T; i++) {
			int apple = Integer.parseInt(br.readLine());
			if (apple < sIndex) {
				result += sIndex - apple;
				eIndex -= sIndex - apple;
				sIndex = apple;
			} else if (apple > eIndex) {
				result += apple - eIndex;
				sIndex += apple - eIndex;
				eIndex = apple;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
