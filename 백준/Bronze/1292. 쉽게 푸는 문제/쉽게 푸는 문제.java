import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int count = 0;
		int num = 1;
		int result = 0;
		for (int i = 0; i < B; i++) {
			count++;
			result += num;
			if (count == num) {
				num++;
				count = 0;
			}
		}

		count = 0;
		num = 1;
		int sum = 0;
		for (int i = 0; i < A - 1; i++) {
			count++;
			sum += num;
			if (count == num) {
				num++;
				count = 0;
			}
		}
		bw.write(String.valueOf(result - sum));
		bw.flush();
	}
}
