import java.io.*;
import java.util.*;

public class Main {

	static LinkedList<Integer> A = new LinkedList<>();
	static LinkedList<Integer> B = new LinkedList<>();
	static LinkedList<Integer> C = new LinkedList<>();
	static LinkedList<Integer> D = new LinkedList<>();
	static int a;
	static int b1;
	static int b2;
	static int c1;
	static int c2;
	static int d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		for (int i = 0; i < s.length(); i++)
			A.add(s.charAt(i) - '0');

		s = br.readLine();
		for (int i = 0; i < s.length(); i++)
			B.add(s.charAt(i) - '0');

		s = br.readLine();
		for (int i = 0; i < s.length(); i++)
			C.add(s.charAt(i) - '0');

		s = br.readLine();
		for (int i = 0; i < s.length(); i++)
			D.add(s.charAt(i) - '0');

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int turnNum = Integer.parseInt(st.nextToken());
			int rotation = Integer.parseInt(st.nextToken());

			// 모든 기어가 초기상태의 기어상태를 기준으로 모든 톱니가 돌아간다...
			a = A.get(2);
			b1 = B.get(2);
			b2 = B.get(6);
			c1 = C.get(2);
			c2 = C.get(6);
			d = D.get(6);

			if (turnNum == 1)
				turnA(rotation, 0);
			else if (turnNum == 2)
				turnB(rotation, 0);
			else if (turnNum == 3)
				turnC(rotation, 0);
			else if (turnNum == 4)
				turnD(rotation, 0);
		}

		int result = 0;
		if (A.getFirst() == 1)
			result += 1;
		if (B.getFirst() == 1)
			result += 2;
		if (C.getFirst() == 1)
			result += 4;
		if (D.getFirst() == 1)
			result += 8;
		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void turnA(int rotation, int from) {
		if (rotation == 1) {
			int get = A.removeLast();
			A.addFirst(get);
			rotation = -1;
		} else {
			int get = A.removeFirst();
			A.addLast(get);
			rotation = 1;
		}
		if (from == 0 && a != b2) // 지금 톱니에서 시작할 때만 B 돌리기
			turnB(rotation, 1);
	}

	static void turnB(int rotation, int from) {
		if (rotation == 1) {
			int get = B.removeLast();
			B.addFirst(get);
			rotation = -1;
		} else {
			int get = B.removeFirst();
			B.addLast(get);
			rotation = 1;
		}
		if (from == 0) {
			if (b2 != a)
				turnA(rotation, 2);
			if (b1 != c2)
				turnC(rotation, 2);
		} else if (from == 1) {
			if (b1 != c2)
				turnC(rotation, 2);
		} else if (from == 3) {
			if (b2 != a)
				turnA(rotation, 2);
		}
	}

	static void turnC(int rotation, int from) {
		if (rotation == 1) {
			int get = C.removeLast();
			C.addFirst(get);
			rotation = -1;
		} else {
			int get = C.removeFirst();
			C.addLast(get);
			rotation = 1;
		}
		if (from == 0) {
			if (c2 != b1)
				turnB(rotation, 3);
			if (c1 != d)
				turnD(rotation, 3);
		} else if (from == 2) {
			if (c1 != d)
				turnD(rotation, 3);
		} else if (from == 4) {
			if (c2 != b1)
				turnB(rotation, 3);
		}
	}

	static void turnD(int rotation, int from) {
		if (rotation == 1) {
			int get = D.removeLast();
			D.addFirst(get);
			rotation = -1;
		} else {
			int get = D.removeFirst();
			D.addLast(get);
			rotation = 1;
		}
		if (from == 0 && d != c1)
			turnC(rotation, 4);
	}
}
