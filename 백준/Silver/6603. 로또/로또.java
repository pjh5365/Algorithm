import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[] S;
	static int[] arr;
	static boolean[] use;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			S = new int[k];
			arr = new int[6];
			use = new boolean[k];
			for (int i = 0; i < k; i++)
				S[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(S);
			find(0);
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();;
	}

	static void find(int l) {
		if (l == 6) {
			for (int i = 0; i < 6; i++)
				sb.append(S[arr[i]]).append(" ");
			sb.append("\n");
			return;
		}
		int start = 0;
		if (l > 0)
			start = arr[l - 1];
		for (int i = start; i < k; i++) {
			if (!use[i]) {
				use[i] = true;
				arr[l] = i;
				find(l + 1);
				use[i] = false;
			}
		}
	}
}
