import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ret = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();

            if (s.length() % 2 != 0) {
                continue;
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == s.charAt(i)) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(s.charAt(i));
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            String s1 = String.valueOf(sb.reverse());
            String s2 = String.valueOf(sb.reverse());

            if (sb.length() == 0 || s1.equals(s2)) {
                ret++;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
