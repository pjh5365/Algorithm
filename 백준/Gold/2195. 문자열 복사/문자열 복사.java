import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 문자열의 길이는 최대 1000이니 완전탐색으로 풀기
	 * P를 0, S의 길이까지 자르고 해당 문자열이 S에 존재하는지 확인 있다면 횟수 증가 없다면 S의 길이 - i 를 반복하면서 존재하는지 확인하기
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ret = 0;

		String S = br.readLine();
		String P = br.readLine();

		while (!P.isEmpty()) {
			for (int i = Math.min(S.length(), P.length()); i > 0; i--) {
				if (S.contains(P.substring(0, i))) {
					ret++;
					P = P.substring(i);
					break; // 필수. 없다면 인덱스 예외 발생
				}
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
