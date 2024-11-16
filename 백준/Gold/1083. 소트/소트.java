import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int S = Integer.parseInt(br.readLine());
		if (N * (1 + N) / 2 < S) {    // S가 그냥 버블정렬로 정렬이 가능하다면
			Arrays.sort(arr);    // 그냥 내림차순으로 출력
			for (int i = N - 1; i >= 0; i--) {
				sb.append(arr[i]).append(" ");
			}
		} else {
			E:
			for (int i = 0; i < N; i++) {
				int max = arr[i];
				int idx = -1;
				// i+1 ~ i+S 에서 i보다 큰값 찾기
				for (int j = i + 1; j < N && j <= i + S; j++) {
					if (arr[j] > max) {
						max = arr[j];
						idx = j;
					}
				}
				if (idx == -1) { // 찾지못했으면 교환할 필요가 없음
					continue;
				}
				S -= idx - i; // 찾았다면 i+S 까지 전부 교환하므로 값 갱신
				for (int j = idx; j >= i + 1; j--) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
				if (S <= 0) {
					break E;
				}
			}
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
		}
		sb.append("\n");
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
