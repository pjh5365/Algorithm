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
		int result = 0;
		int max = arr[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			while (arr[i] >= max) {
				arr[i]--;
				result++;
			}
			max = arr[i];
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
