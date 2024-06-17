import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int result = 0;
		int index = 0;
		while (index < input.length()) {
			result++;
			String resultS = Integer.toString(result);
			for (int i = 0; i < resultS.length(); i++) {
				if (resultS.charAt(i) == input.charAt(index)) { // 포함하고 있다면 다음수로 넘어가기
					index++;
				}
				if (index == input.length()) {
					break;
				}
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
