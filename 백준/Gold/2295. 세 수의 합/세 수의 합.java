import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				list.add(arr[i] + arr[j]);
			}
		}
		Collections.sort(list);

		int result = 0;
		L:
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (binarySearch(list, arr[i] - arr[j])) {
					result = arr[i];
					break L;
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static boolean binarySearch(ArrayList<Integer> list, int key) {
		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) > key) {
				end = mid - 1;
			} else if (list.get(mid) < key) {
				start = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
