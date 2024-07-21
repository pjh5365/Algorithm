import java.io.*;
import java.util.*;

public class Main {
	// 참고: https://github.com/encrypted-def/basic-algo-lecture/blob/master/0x14/solutions/2283.cpp
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[1000001]; // 구간의 선분개수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for (int j = start; j < end; j++) {
				arr[j]++;
			}
		}

		int B = 0;
		int sum = arr[0]; // 0에서부터 시작
		for (int A = 0; A < 1000000; A++) {
			while (B < 1000000 && sum < K) { // 더 늘려야한다면
				B++;
				if (B != 1000000) { // 마지막구간이 아니라면 선분 더하기
					sum += arr[B];
				}
			}
			if (B == 1000000) { // 마지막에 도달했다면 값을 찾을 수 없다.
				sb.append("0 0");
				break;
			}
			if (sum == K) { // 값을 찾은경우
				sb.append(A).append(" ").append(B + 1);
				break;
			}
			sum -= arr[A]; // 시작점 한칸이동
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
