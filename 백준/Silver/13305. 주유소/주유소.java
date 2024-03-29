import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] length = new int[N - 1];
		int[] price = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		long result = 0;
		long minPrice = price[0];
		long tmpLength = 0;
		int beforeIndex = 0;
		for (int i = 1; i < N - 1; i++) {
			if (minPrice > price[i]) { // 가장 비용이 작은 주유소를 발견했다면
				for (int j = beforeIndex; j < i; j++) {
					tmpLength += length[j]; // 모든 거리 더해서
				}
				result += tmpLength * minPrice; // 결과에 반영
				minPrice = price[i]; // 갱신
				tmpLength = 0; // 거리 초기화
				beforeIndex = i; // 시작인덱스 변경
			}
		}
		for (int i = beforeIndex; i < N - 1; i++) { // 마지막 도착지까지 주유
			tmpLength += length[i];
		}
		result += tmpLength * minPrice;

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
