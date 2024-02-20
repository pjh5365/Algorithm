import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int L;
	static int C;
	static char[] input;
	static boolean[] vowel;
	static int[] arr;
	static boolean[] use;
	static int check1;
	static int check2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		input = new char[C];
		vowel = new boolean[C];
		use = new boolean[C];
		arr = new int[C];

		String s = br.readLine();
		s = s.replace(" ", "");
		for (int i = 0; i < C; i++)
			input[i] = s.charAt(i);

		Arrays.sort(input);

		for (int i = 0; i < C; i++) {
			if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u')
				vowel[i] = true;
		}

		find(0);

		bw.write(String.valueOf(sb));
		bw.flush();;
	}

	static void find(int k) {
		if (k == L) {
			check1 = check2 = 0;
			for (int i = 0; i < L; i++)  {
				if (vowel[arr[i]])
					check1++;
				else
					check2++;
			}

			boolean isOk = false;
			if (check1 >= 1 && check2 >= 2) {
				isOk = true;
			}

			if (isOk) {
				for (int i = 0; i < L; i++)
					sb.append(input[arr[i]]);
				sb.append("\n");
			}
			return;
		}
		int start = 0;
		if (k > 0)
			start = arr[k - 1];
		for (int i = start; i < C; i++) {
			if (!use[i]) {
				use[i] = true;
				arr[k] = i;
				find(k + 1);
				use[i] = false;
			}
		}
	}
}
