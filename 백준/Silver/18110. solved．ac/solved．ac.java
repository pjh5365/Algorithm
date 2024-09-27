import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int ret = 0;

		int[] arr = new int[n];
		double num = Math.round(n * 0.15);
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int i = (int)(num); i < n - num; i++) {
			sum += arr[i];
		}

		ret = (int)Math.round(sum / (n - (2*num)));
		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
