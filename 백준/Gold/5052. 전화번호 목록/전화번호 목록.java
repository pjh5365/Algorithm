import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] phone = new String[n];
			for (int i = 0; i < n; i++) {
				phone[i] = br.readLine();
			}
			Arrays.sort(phone);
			boolean isOk = true;
			for (int i = 0; i < n - 1; i++) {
				if (phone[i + 1].startsWith(phone[i])) {
					isOk = false;
					break;
				}
			}
			if (isOk) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
			t--;
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
