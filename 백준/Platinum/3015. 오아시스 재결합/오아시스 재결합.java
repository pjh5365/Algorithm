import java.io.*;
import java.util.*;

public class Main {
	// 참고 : https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-3015-%EC%98%A4%EC%95%84%EC%8B%9C%EC%8A%A4-%EC%9E%AC%EA%B2%B0%ED%95%A9-Java%EC%9E%90%EB%B0%94
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Stack<Person> s = new Stack<>();

		s.push(new Person(Integer.parseInt(br.readLine()), 1));    // 최초 입력은 스택에 미리 삽입
		long result = 0;
		for (int i = 1; i < N; i++) {
			int now = Integer.parseInt(br.readLine());    // 현재 사람 입력받기
			int count = 1;    // 한 사람의 최소쌍은 1
			while (!s.isEmpty() && s.peek().h <= now) {    // 현재 사람이 앞 사람 보다 키가 크거나 같아 앞 사람을 빼는 경우
				Person tmp = s.pop();    // 앞 사람은 쌍을 이룰 수 없으므로 빼기
				result += tmp.count;    // 앞 사람의 쌍 더하기

				if (now == tmp.h) {    // 앞 사람과 같은 경우 앞 사람의 개수에 +1 해서 넣기
					count = tmp.count + 1;
					break;
				}
			}
			if (!s.isEmpty()) {    // 스택에 값이 남아 있다면 남아있는 사람과 마주볼 수 있으므로 +1
				result++;
			}
			s.push(new Person(now, count));    // 현재 사람 스택에 삽입
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static class Person {
		int h;    // 키
		int count;    // 쌍의 개수

		public Person(int h, int count) {
			this.h = h;
			this.count = count;
		}
	}
}
