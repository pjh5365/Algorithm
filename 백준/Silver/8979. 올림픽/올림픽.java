import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Country> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Country tmp = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			if (now == K) { // 원하는 국가의 정보 저장
				tmp = new Country(gold, silver, bronze, now);
			}
			list.add(new Country(gold, silver, bronze, now));
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			Country get = list.get(i);
			// 동점일땐 동점자 맨 앞의 등수와 내 등수가 같다. 
			if (get.gold == tmp.gold && get.silver == tmp.silver && get.bronze == tmp.bronze) {
				bw.write(String.valueOf(i + 1));
				break;
			}
		}
		bw.flush();
	}

	static class Country implements Comparable<Country> {
		int gold;
		int silver;
		int bronze;
		int now;

		public Country(int gold, int silver, int bronze, int now) {
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.now = now;
		}

		@Override
		public int compareTo(Country c) {
			if (this.gold > c.gold) {
				return -1;
			} else if (this.gold == c.gold) {
				if (this.silver > c.silver) {
					return -1;
				} else if (this.silver == c.silver) {
					if (this.bronze > c.bronze) {
						return -1;
					} else if (this.bronze == c.bronze) { // 동점일때
						return 0;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
