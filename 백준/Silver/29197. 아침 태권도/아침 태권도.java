import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 29197 - 정점의 기울기가 같다면 원점에서 볼 수 있는건 하나밖에 없다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<Pair> s = new HashSet<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int posX = (x < 0 ? -x : x), posY = (y < 0 ? -y : y);
			int gcd = posX > posY ? gcd(posX, posY) : gcd(posY, posX);
			s.add(new Pair(x / gcd, y / gcd));
		}
		bw.write(String.valueOf(s.size()));
		bw.flush();
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass())
				return false;
			Pair pair = (Pair)o;
			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
