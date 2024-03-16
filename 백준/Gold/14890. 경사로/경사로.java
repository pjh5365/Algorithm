import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int L;
	static int[][] arr;
	static ArrayList<Integer> line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) { // 가로 방향
			line = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				line.add(arr[i][j]);
			}
			result += check();
		}
		for (int i = 0; i < N; i++) { // 세로 방향
			line = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				line.add(arr[j][i]);
			}
			result += check();
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static int check() {
		int count = 1; // 높이가 같은 구간 카운트
		int index = 0;
		while (index + 1 < N) {
			if (line.get(index) == line.get(index + 1)) { // 높이가 같다면
				count++;
				index++;
			} else if (line.get(index) - line.get(index + 1) == -1) { // 올라가는 경사로를 놓는다면
				if (count < L) { // 경사를 놓을 수 없다면
					return 0;
				}
				count = 1;
				index++;
			} else if (index + L < N && line.get(index) - line.get(index + 1) == 1) { // 내려가는 경사로를 놓는다면
				for (int i = index + 1; i < index + L; i++) { // 다음칸부터 L 만큼 높이가 같은지 확인
					if (line.get(i) != line.get(i + 1)) { // 경사로 설치 불가
						return 0;
					}
				}
				index += L; // 설치한 칸부터 시작
				count = 0; // 설치한 다음칸부터 설치할 수 있으니 0으로 초기화
			} else {
				return 0;
			}
		}
		return 1;
	}
}
