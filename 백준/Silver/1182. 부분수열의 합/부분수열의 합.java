import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int count = 0;
	static int[] arr;
	static int N;
	static int S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		find(0, 0);
		if (S == 0) // 공집합 제외
			count--;
		bw.write(String.valueOf(count));
		bw.flush();
	}

	static void find(int k, int sum) {
		if (k == N) { // 종료 조건
			if (sum == S)
				count++;
			return;
		}
		find(k + 1, sum); // 현재 원소를 더하지 않는 경우
		find(k + 1, sum + arr[k]); // 현재 원소를 더하는 경우
	}
}
