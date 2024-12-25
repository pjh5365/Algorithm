import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10];
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		long ret = (long)A * B * C;

		String s = String.valueOf(ret);
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - '0']++;
		}
		for (int i = 0; i < 10; i++) {
			sb.append(arr[i]).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
