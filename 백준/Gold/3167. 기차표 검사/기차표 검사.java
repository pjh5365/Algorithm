import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] += Integer.parseInt(st.nextToken()); // 내리는 인원
			arr[i][1] += Integer.parseInt(st.nextToken()); // 탑승하는 인원
		}

		int min = getMin(arr, N, K);
		int max = getMax(arr, N, K);

		bw.write(min + " " + max);
		bw.flush();
	}

	static int getMin(int[][] arr, int N, int K) {
		int min = 0;
		int check = arr[0][1]; // 첫번째 역에서 두번째 역으로 가는 인원은 항상 검사
		int nc = 0; // 검표받지 않은 인원
		int station = 0; // 기차역

		for (int i = 1; i < N; i++) {
			int out = arr[i][0]; // 현재역에서 내리는 사람
			if (out <= check) { // 검표한 사람들만 내리는게 가능하다면
				check -= out;
			} else { // 검표한사람 + 검표안한사람이 내림
				out -= check; // 검표한 사람 빼기 (검표안하고 내린 사람 구하기)
				check = 0; // 검표한 사람이 다 내렸으므로 0으로 초기화
				nc -= out; // 검표안하고 내린사람 빼기
				min += out; // 검표안하고 내린 최소인원 더하기
			}
			nc += arr[i][1]; // 검표안한 탑승객 추가
			if (station + K == i) { // 검표할 구간이라면
				station = i;
				check += nc; // 검표안한사람 모두 검표
				nc = 0; // 검표안한사람은 0으로 초기화
			}
		}
		return min;
	}

	static int getMax(int[][] arr, int N, int K) {
		int max = 0;
		int check = arr[0][1]; // 첫번째 역에서 두번째 역으로 가는 인원은 항상 검사
		int nc = 0; // 검표받지 않은 인원
		int station = 0; // 기차역

		for (int i = 1; i < N; i++) {
			int out = arr[i][0]; // 현재역에서 내리는 사람
			if (out <= nc) { // 검표안한사람부터 내리는게 가능할때
				nc -= out; // 검표 안하고 내린사람 빼기
				max += out; // 검표 안하고 내린 인원 결과에 더하기
			} else { // 검표한사람 + 검표안한사람이 내림
				out -= nc; // 검표안한 사람 빼기 (검표하고 내린 사람 구하기)
				check -= out; // 검표한 사람 내리기
				max += nc; // 검표 안하고 내린사람 결과에 더하기
				nc = 0; // 검표 안한사람 0으로 초기화
			}
			nc += arr[i][1]; // 검표안한 탑승객 추가
			if (station + K == i) { // 검표할 구간이라면
				station = i;
				check += nc; // 검표안한사람 모두 검표
				nc = 0; // 검표안한사람은 0으로 초기화
			}
		}
		return max;
	}
}
