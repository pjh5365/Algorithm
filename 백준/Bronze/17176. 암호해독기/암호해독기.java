import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                list.add(' ');
            } else if (n <= 26 && n >= 1) {
                n = n + 'A' - 1;
                list.add((char) n);
            } else if (n <= 52 && n >= 27) {
                n = n + 'a' - 27;
                list.add((char) n);
            }
        }
        int[] arr = new int[200];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (Character c : list) {
            if (arr[c] != 0) {
                arr[c]--;
            }
        }
        int check = 0;
        for (int j : arr) {
            check += j;
        }
        if (check == 0) {
            bw.write(String.valueOf('y'));
        } else {
            bw.write(String.valueOf('n'));
        }

        bw.flush();
    }
}
