import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int ret = 0;

		while (N > 0) {
			while (N >= cnt) {
				N -= cnt;
				cnt++;
				ret++;
			}
			cnt = 1;
		}

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
