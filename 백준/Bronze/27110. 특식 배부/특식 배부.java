import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[3];
		int result = 0;

		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] <= N)
				result += arr[i];
			else
				result += N;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
