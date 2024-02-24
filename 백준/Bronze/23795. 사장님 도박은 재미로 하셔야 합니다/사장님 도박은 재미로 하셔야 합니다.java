import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int result = 0;

		int input = 0;
		while (true) {
			input = Integer.parseInt(br.readLine());
			if (input == -1)
				break;
			result += input;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
