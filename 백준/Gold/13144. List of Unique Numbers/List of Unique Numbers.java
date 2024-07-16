import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		long result = 0;
		int index = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
			} else {
				while (set.contains(arr[i])) {
					set.remove(arr[index]);
					index++;
				}
				set.add(arr[i]);
			}
			result += set.size();
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
