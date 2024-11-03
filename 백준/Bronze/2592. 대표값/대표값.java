import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[1001];
		int maxValue = 0;
		int max = 0;
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
			arr[n]++;
			if (maxValue < arr[n]) {
				maxValue = arr[n];
				max = n;
			}
		}

		sb.append(sum / 10).append("\n");
		sb.append(max).append("\n");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
