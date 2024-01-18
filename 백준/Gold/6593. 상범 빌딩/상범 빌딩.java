import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int[] checkX = {1, -1, 0, 0, 0, 0};
		int[] checkY = {0, 0, 1, -1, 0, 0};
		int[] checkZ = {0, 0, 0, 0, 1, -1};

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());

			if (X == 0 && Y == 0 && Z == 0)
				break;

			int[][][] arr = new int[X][Y][Z];
			Queue<Pair> q = new LinkedList<>();
			Pair destination = null;
			for (int i = 0; i < X; i++) {
				for (int j = 0; j < Y; j++) {
					String input = br.readLine();
					for (int k = 0; k < Z; k++) {
						char now = input.charAt(k);
						if (now == 'S')
							q.add(new Pair(i, j, k));
						else if (now == '#')
							arr[i][j][k] = -1;
						else if (now == 'E')
							destination = new Pair(i, j, k);
					}
				}
				br.readLine();
			}
			boolean no = true;
			while (!q.isEmpty()) {
				Pair now = q.poll();
				for (int j = 0; j < 6; j++) {
					int x = now.x + checkX[j];
					int y = now.y + checkY[j];
					int z = now.z + checkZ[j];

					if (x < 0 || x >= X || y < 0 || y  >= Y || z < 0 || z >= Z)
						continue;

					if (arr[x][y][z] == 0) {
						q.add(new Pair(x, y, z));
						arr[x][y][z] = arr[now.x][now.y][now.z] + 1;
					}

					if (destination.x == x && destination.y == y && destination.z == z) {
						no = false;
						sb.append("Escaped in ").append(arr[destination.x][destination.y][destination.z]).append(" minute(s).").append("\n");
						q.clear();
						break;
					}
				}
			}
			if (no)
				sb.append("Trapped!").append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		int z;

		public Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
