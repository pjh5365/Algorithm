import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int w;
	static int L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Queue<Integer> truck = new LinkedList<>();
		for (int i = 0; i < n; i++)
			truck.add(Integer.parseInt(st.nextToken()));

		int result = 0;
		int total = 0; // 다리 위 무게 총합

		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++)
			bridge.add(0);

		while (true) {
			result++;
			total -= bridge.poll(); // 다리 위의 무게 제거

			if (!truck.isEmpty()) { // 트럭이 아직 남아있다면
				if (truck.peek() + total <= L) { // 트럭이 올라갈 수 있다면
					total += truck.peek();
					bridge.add(truck.poll());
				} else  // 올라갈 수 없다면 0 입력
					bridge.add(0);
			}
			if (bridge.isEmpty()) // 모든 탐색이 종료되면
				break;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
