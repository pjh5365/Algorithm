import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] s = new String[N];
		int kbs1 = 0;
		int kbs2 = 0;

		for (int i = 0; i < N; i++) {
			s[i] = br.readLine();
			if (s[i].equals("KBS1")) {
				kbs1 = i;
			} else if (s[i].equals("KBS2")) {
				kbs2 = i;
			}
		}
		for (int i = 0; i < kbs2; i++) {
			sb.append("1");
		}
		for (int i = 0; i < kbs2; i++) {
			sb.append("4");
		}
		if (kbs2 > kbs1) {
			kbs1++;
		}
		for (int i = 0; i < kbs1; i++) {
			sb.append("1");
		}
		for (int i = 0; i < kbs1; i++) {
			sb.append("4");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
