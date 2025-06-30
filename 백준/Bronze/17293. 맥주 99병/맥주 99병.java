import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 1; i--) {
            sb.append(i).append(" bottles of beer on the wall, ").append(i).append(" bottles of beer.").append("\n");
            if (i == 2) {
                sb.append("Take one down and pass it around, ").append(i - 1).append(" bottle of beer on the wall.").append("\n");
            } else {
                sb.append("Take one down and pass it around, ").append(i - 1).append(" bottles of beer on the wall.").append("\n");
            }
            sb.append("\n");
        }
        if (N == 1) {
            sb.append("1 bottle of beer on the wall, 1 bottle of beer.\n"
                    + "Take one down and pass it around, no more bottles of beer on the wall.\n" + "\n"
                    + "No more bottles of beer on the wall, no more bottles of beer.\n"
                    + "Go to the store and buy some more, ").append(N).append(" bottle of beer on the wall.\n");
        } else {
            sb.append("1 bottle of beer on the wall, 1 bottle of beer.\n"
                    + "Take one down and pass it around, no more bottles of beer on the wall.\n" + "\n"
                    + "No more bottles of beer on the wall, no more bottles of beer.\n"
                    + "Go to the store and buy some more, ").append(N).append(" bottles of beer on the wall.\n");
        }

        bw.write(sb + "");
        bw.flush();
    }
}
