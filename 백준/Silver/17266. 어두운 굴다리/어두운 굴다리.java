import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 가로등의 최대 높이는 100,000
		// 최소 높이는 1

		int start = 100000;
		int end = 0;
		int length = 1;
		while (true) {
			start = arr[0] - length;
			for (int i = 0; i < M; i++) {
				int newStart = arr[i] - length;
				int newEnd = arr[i] + length;
				if (newStart <= end) { // 중간에 빈 곳이 없을 때만
					end = newEnd;
				} else { // 빈곳이 생긴다면 종료
					break;
				}
			}
			if (start <= 0 && end >= N) {
				break;
			} else {
				length++;
			}
		}

		bw.write(String.valueOf(length));
		bw.flush();
	}
}
