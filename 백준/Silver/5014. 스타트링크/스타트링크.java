import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());	// 총 층
		int S = Integer.parseInt(st.nextToken());	// 현재위치
		int G = Integer.parseInt(st.nextToken());	// 목적지
		int U = Integer.parseInt(st.nextToken());	// 위로 몇칸
		int D = Integer.parseInt(st.nextToken());	// 아래로 몇칸

		int[] arr = new int[F + 1];
		Queue<Integer> q = new LinkedList<>();

		q.add(S);
		arr[S] = 1;
		while (!q.isEmpty()) {
			int now = q.poll();
			int up = now + U;
			int down = now - D;

			if (up <= F) {
				if (arr[up] == 0) {
					q.add(up);
					arr[up] = arr[now] + 1;
				}
			}
			if (down > 0) {
				if (arr[down] == 0) {
					q.add(down);
					arr[down] = arr[now] + 1;
				}
			}
		}
		if (arr[G] != 0)
			bw.write(String.valueOf(arr[G] - 1));
		else if (S == G)
			bw.write("0");
		else
			bw.write("use the stairs");
		bw.flush();
	}
}
