import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new char[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j);
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = Math.max(result, findX());
				result = Math.max(result, findY());
				// 오른쪽값과 교환
				char tmp = arr[i][j + 1];
				arr[i][j + 1] = arr[i][j];
				arr[i][j] = tmp;
				result = Math.max(result, findX());
				result = Math.max(result, findY());
				// 오른쪽값과 교환
				tmp = arr[i][j + 1];
				arr[i][j + 1] = arr[i][j];
				arr[i][j] = tmp;

				// 아래쪽값과 교환
				tmp = arr[i + 1][j];
				arr[i + 1][j] = arr[i][j];
				arr[i][j] = tmp;
				result = Math.max(result, findX());
				result = Math.max(result, findY());
				// 아래쪽값과 교환
				tmp = arr[i + 1][j];
				arr[i + 1][j] = arr[i][j];
				arr[i][j] = tmp;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static int findX() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					count++;
					max = Math.max(max, count);
				} else {
					count = 1;
				}
			}
		}
		return max;
	}

	static int findY() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					count++;
					max = Math.max(max, count);
				} else {
					count = 1;
				}
			}
		}
		return max;
	}
}
