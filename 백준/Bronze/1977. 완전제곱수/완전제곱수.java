import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		double tmp = Math.sqrt(M);
		int num = (int)tmp;
		if (tmp - (int)tmp > 0) {
			num++;
		}
		int sum = 0;
		for (int i = num; i * i <= N; i++) {
			sum += i * i;
		}
		if (sum != 0) {
			sb.append(sum).append("\n").append(num * num).append("\n");
		} else {
			sb.append("-1").append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
