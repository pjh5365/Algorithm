import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long total = 0;
		boolean fail = false;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			int v = Integer.parseInt(st.nextToken());
			
			if (c.equals("in")) {
				total += v;
			} else {
				if (total - v < 0) {
					fail = true;
					break;
				}
				total -= v;
			}
			
			// if (total < 0) {
			// 	fail = true;
			// 	break;
			// }
		}
		if (!fail) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
}