import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char[][] S;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		S = new char[N][N];
		arr = new int[N];

		String input = br.readLine();
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				S[i][j] = input.charAt(index++);
			}
		}

		find(0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void find(int k) {
		if (!sb.toString().isEmpty()) {
			return;
		}
		if (k == N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			return;
		}

		for (int i = -10; i <= 10; i++) {
			arr[k] = i;
			boolean check = true;
			if (S[k][k] == '0' && arr[k] != 0) {
				check = false;
			} else if (S[k][k] == '-' && arr[k] >= 0) {
				check = false;
			} else if (S[k][k] == '+' && arr[k] <= 0) {
				check = false;
			}
			for (int j = 0; j <= k; j++) {
				int sum = 0;
				for (int l = j; l <= k; l++) {
					sum += arr[l];
					if (S[j][l] == '0' && sum != 0) {
						check = false;
					} else if (S[j][l] == '-' && sum >= 0) {
						check = false;
					} else if (S[j][l] == '+' && sum <= 0) {
						check = false;
					}
				}
			}
			if (check) {
				find(k + 1);
			}
		}
	}
}
