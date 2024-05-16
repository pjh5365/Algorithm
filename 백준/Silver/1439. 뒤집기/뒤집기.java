import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		// 0이 있는 구간, 1이 있는 구간을 카운트하여 최소값 출력하기
		int count0 = 0;
		int count1 = 0;
		if (input.charAt(0) == '0') {
			count0++;
		} else {
			count1++;
		}
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(i - 1)) {
				if (input.charAt(i) == '0') {
					count0++;
				} else {
					count1++;
				}
			}
		}

		bw.write(String.valueOf(Math.min(count0, count1)));
		bw.flush();
	}
}
