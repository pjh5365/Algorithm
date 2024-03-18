import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		while (N > 3) {
			N -= 3;
			count++;
		}
		count += N;
		if (count % 2 == 0) {
			bw.write(String.valueOf("CY"));
		} else {
			bw.write(String.valueOf("SK"));
		}
		bw.flush();
	}
}
