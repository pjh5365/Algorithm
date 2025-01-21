import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 1000; i < 10000; i++) {
			int sum10 = 0;
			int sum12 = 0;
			int sum16 = 0;

			for (int j = i; j > 0; j /= 10) {
				sum10 += j % 10;
			}

			for (int j = i; j > 0; j /= 12) {
				sum12 += j % 12;
			}

			for (int j = i; j > 0; j /= 16) {
				sum16 += j % 16;
			}

			if (sum10 == sum12 && sum12 == sum16) {
				sb.append(i).append("\n");
			}
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
