import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int P = Integer.parseInt(br.readLine());
		int[] arr;

		while (P > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int total = 0;
			arr = new int[20];

			for (int i = 0; i < 20; i++) {
				int count = 0;
				arr[i] = Integer.parseInt(st.nextToken());
				if (i > 0) {
					for (int j = i; j >= 0; j--) {
						if (arr[i] < arr[j]) {	// 새로운 학생이 키가 작은 경우
							count++;
						}
					}
					Arrays.sort(arr, 0, i + 1);
					total += count;
				}
			}
			sb.append(num).append(" ").append(total).append("\n");
			P--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
