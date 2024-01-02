import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		LinkedList<Node> deque = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			Node node = new Node(Integer.parseInt(st.nextToken()), i);

			while (!deque.isEmpty() && deque.getLast().value > node.value) {	// 마지막에 들어있는 숫자가 현재 값보다 크다면 전부 빼기
				deque.removeLast();
			}
			deque.addLast(node);
			while (!deque.isEmpty() && deque.getFirst().index <= i - L) {	// 맨 앞에 있는 수의 인덱스가 경계를 넘어가는 경우 빼기
				deque.removeFirst();
			}
			sb.append(deque.getFirst().value).append(" ");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static class Node implements Comparable<Node> {
		int value;
		int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
}
