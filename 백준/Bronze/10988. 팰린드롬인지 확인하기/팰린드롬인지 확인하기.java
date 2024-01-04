import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int index = input.length() - 1;
		int i = 0;
		int result = 0;
		boolean no = false;
		while (true) {
			if (input.charAt(i) != input.charAt(index)) {
				no = true;
				break;
			}
			i++;
			index--;
			if (i >= index) {
				break;
			}
		}

		if (!no) {
			result = 1;
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
