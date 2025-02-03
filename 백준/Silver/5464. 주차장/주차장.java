import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] Rs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Rs[i] = Integer.parseInt(br.readLine());
		}

		int[] car = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			car[i] = Integer.parseInt(br.readLine());
		}

		Queue<Integer> q = new LinkedList<>(); // 대기열
		int[] park = new int[N + 1];
		int cnt = 0;
		int ret = 0;
		for (int i = 0; i < 2 * M; i++) {
			int now = Integer.parseInt(br.readLine());
			if (now > 0 && cnt < N) { // 진입
				cnt++;
				for (int j = 1; j <= N; j++) {
					if (park[j] == 0) {
						ret += Rs[j] * car[now];
						park[j] = now;
						break;
					}
				}
			} else if (now > 0 && cnt == N){
				q.add(now);
			} else if (now < 0) { // 퇴장
				for (int j = 1; j <= N; j++) {
					if (park[j] == Math.abs(now)) {
						park[j] = 0;
						cnt--;
						break;
					}
				}
				if (!q.isEmpty()) {
					for (int j = 1; j <= N; j++) {
						if (park[j] == 0) {
							park[j] = q.poll();
							ret += Rs[j] * car[park[j]];
							cnt++;
							break;
						}
					}
				}
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
