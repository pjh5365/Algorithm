import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s.equals("end")) {
				break;
			}

			boolean one = false;
			boolean three = true;
			int count1 = 0;
			int count2 = 0;

			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') { // 모음일때
					one = true;
					count2 = 0; // 자음 0으로 초기화
					count1++; // 모음 카운트++
					if (i >= 1 && (now == s.charAt(i - 1))) { // 같은 글자가 연속이라면
						three = false;
						if (now == 'e' || now == 'o') { // ee, oo는 허용
							three = true;
						}
					}
				} else { // 자음일때
					count1 = 0; // 모음 0으로 초기화
					count2++; // 자음++
					if (i >= 1 && (now == s.charAt(i - 1))) { // 같은글자
						three = false;
					}
				}

				if (count1 == 3 || count2 == 3) { // 모음, 자음이 연속 3개 온다면
					three = false;
					break;
				}
			}
			sb.append("<").append(s).append("> is ");
			if (one && three) {
				sb.append("acceptable.").append("\n");
			} else {
				sb.append("not acceptable.").append("\n");
			}
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
