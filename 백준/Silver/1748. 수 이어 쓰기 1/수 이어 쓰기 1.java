import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int result = 0;
		int sum = 1;
		int digit = 10;

		for (int i = 1; i <= N; i++) {
			if (i % digit == 0) {
				sum++;
				digit *= 10;
			}
			result += sum;
		}


		bw.write(String.valueOf(result));
		bw.flush();
	}
}
