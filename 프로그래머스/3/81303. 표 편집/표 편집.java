import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> s = new Stack<>(); // 삭제한 인덱스를 담는 스택

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        k++;

        for (String str : cmd) {
            char now = str.charAt(0);
            if (now == 'C') {
                s.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            } else if (now == 'Z') {
                int idx = s.pop();
                down[up[idx]] = idx;
                up[down[idx]] = idx;
            } else {
                String[] tmp = str.split(" ");
                int x = Integer.parseInt(tmp[1]);
                for (int i = 0; i < x; i++) {
                    k = tmp[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        char[] ret = new char[n];
        Arrays.fill(ret, 'O'); // O 로 초기화

        for (int i : s) {
            ret[i - 1] = 'X';
        }

        return new String(ret);
    }
}