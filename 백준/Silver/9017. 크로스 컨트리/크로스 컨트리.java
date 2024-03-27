import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N + 1];
			int[] team = new int[1001]; // 완주한 팀원 수
			int[] result = new int[1001]; // 팀당 최종 점수 (1 ~ 4명 까지)
			int[] count = new int[1001]; // 팀당 인원 카운트
			int[] tmp = new int[1001]; // 팀당 5번째 인원의 점수

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				team[arr[i]]++;
			}
			int score = 1;
			for (int i = 1; i <= N; i++) {
				if (team[arr[i]] == 6) {
					if (count[arr[i]] < 4) { // 팀당 4명까지만 합산
						result[arr[i]] += score;
					}
					score++;
					count[arr[i]]++;
					if (count[arr[i]] == 5) { // 팀당 5번째 인원점수 저장
						tmp[arr[i]] = score - 1;
					}
				}
			}
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 1; i <= N; i++) {
				if (result[arr[i]] != 0) {
					if (min > result[arr[i]]) { // 새로운 최소점수가 나타나면 갱신
						min = result[arr[i]];
						minIndex = arr[i];
						// System.out.println("minIndex = " + minIndex + " arr[i]" + arr[i]);
					} else if (min == result[arr[i]]) { // 점수가 같은 경우 5번째 선수의 점수로 비교
						if (tmp[arr[i]] < tmp[minIndex]) {
							min = result[arr[i]];
							minIndex = arr[i];
						}
					}
				}
			}
			sb.append(minIndex).append("\n");
			T--;
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
