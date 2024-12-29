import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[1 << 10]; // 0 ~ 9까지의 10개 숫자 저장을 위한 배열 선언
		long ret = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int tmp = 0;
			for (int j = 0; j < s.length(); j++) {
				tmp |= (1 << (s.charAt(j) - '0')); // 현재 숫자를 비트마스크로 변환
			}
			cnt[tmp]++;
		}

		for (int i = 0; i < (1 << 10); i++) {
			for (int j = 0; j < (1 << 10); j++) {
				if ((i & j) != 0) { // 교집합이 존재
					ret += (long)cnt[i] * cnt[j];
				}
			}
		}

		ret = (ret - N) / 2; // 결과에서 자기 숫자를 먼저 빼고 2번 계산된 중복 제거
		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
