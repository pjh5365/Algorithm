import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] durability;
	static int[] weight;
	static int count = 0;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		durability = new int[N];
		weight = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			durability[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}

		find(0);

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void find(int k) {
		if (k == N) { // 항상 최대 결과를 가지도록
			result = Math.max(result, count);
			return;
		}

		if (durability[k] <= 0 || count == N - 1) { // 현재 계란이 깨진 상태거나 들고 있는 계란을 제외한 모든 계란이 깨진 상태라면 넘어가기
			find(k + 1);
			return;
		}

		// 들고있는 계란은 놓인 계란 중 단 하나만 칠 수 있다.
		// 모든 경우의 수를 확인해야하므로
		for (int i = 0; i < N; i++) {
			if (i == k || durability[i] <= 0) // 들고있는 계란이거나 내구도가 0 이하인 경우 넘어가기
				continue;

			// 들고 있는 계란과 놓인 계란을 부딪치기
			durability[k] -= weight[i];
			durability[i] -= weight[k];

			// 계란이 깨진게 있다면 ++
			if (durability[k] <= 0)
				count++;
			if (durability[i] <= 0)
				count++;
			find(k + 1); // 계란 하나를 쳤으니 다음 계란으로 넘어가기

			// 깨진 계란 복구
			if (durability[k] <= 0)
				count--;
			if (durability[i] <= 0)
				count--;
			durability[k] += weight[i];
			durability[i] += weight[k];

		}
	}
}
