import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int total = Integer.parseInt(br.readLine());

		for (int i = 0; i < 9; i++) {
			int tmp = Integer.parseInt(br.readLine());
			total -= tmp;
		}

		bw.write(String.valueOf(total));
		bw.flush();
	}
}
