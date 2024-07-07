import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());

		int[] A = new int[nA];
		int[] B = new int[nB];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nA; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nB; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int count = 0;
		for (int i = 0; i < nA; i++) {
			if (!binarySearch(B, A[i])) {
				count++;
				sb.append(A[i]).append(" ");
			}
		}

		if (count == 0) {
			bw.write("0");
		} else {
			bw.write(String.valueOf(count));
			bw.newLine();
			bw.write(String.valueOf(sb));
		}
		bw.flush();
	}

	static boolean binarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] > key) {
				end = mid - 1;
			} else if (arr[mid] < key) {
				start = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
