import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];
		int[] count = new int[K + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
		}

		int result = 0;
		Set<Integer> plug = new HashSet<>();

		for (int i = 0; i < K; i++) {
			if (plug.size() < N) { // 플러그에 공간이 있는경우
				plug.add(arr[i]);
				count[arr[i]]--;
			} else { // 플러그가 모두 사용중이라면
				if (!plug.contains(arr[i])) { // 플러그에 현재 값이 없다면
					Optional<Integer> any = plug.stream().filter(o -> count[o] == 0).findAny(); // 전부 사용된 용품 중 아무거나 찾기
					if (any.isEmpty()) { // 모두 사용된 용품이 없다면
						int tmp = 0;
						boolean[] check = new boolean[K + 1];
						for (int j = i; j < K; j++) {
							if (plug.contains(arr[j]) && !check[arr[j]]) { // 존재하는 플러그 중 가장 나중에 다시 사용되는 플러그 찾기
								check[arr[j]] = true;
								tmp++;
							}
							if (tmp == N) { // 현재 플러그 중 가장 나중에 사용되는 플러그 제거
								plug.remove(arr[j]);
								plug.add(arr[i]);
								count[arr[i]]--;
								break;
							}
						}
					} else {
						plug.remove(any.get());
						plug.add(arr[i]);
						count[arr[i]]--;
					}
					result++;
				} else { // 이미 플러그에 있다면
					count[arr[i]]--;
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
