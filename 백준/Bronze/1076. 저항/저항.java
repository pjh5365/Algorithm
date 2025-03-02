import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        long ret = 0;
        switch (a) {
            case "black": ret += 0; break;
            case "brown": ret += 10; break;
            case "red": ret += 20; break;
            case "orange": ret += 30; break;
            case "yellow": ret += 40; break;
            case "green": ret += 50; break;
            case "blue": ret += 60; break;
            case "violet": ret += 70; break;
            case "grey": ret += 80; break;
            case "white": ret += 90; break;
        }

        switch (b) {
            case "brown": ret += 1; break;
            case "red": ret += 2; break;
            case "orange": ret += 3; break;
            case "yellow": ret += 4; break;
            case "green": ret += 5; break;
            case "blue": ret += 6; break;
            case "violet": ret += 7; break;
            case "grey": ret += 8; break;
            case "white": ret += 9; break;
        }

        switch (c) {
            case "brown": ret *= 10; break;
            case "red": ret *= 100; break;
            case "orange": ret *= 1000; break;
            case "yellow": ret *= 10000; break;
            case "green": ret *= 100000; break;
            case "blue": ret *= 1000000; break;
            case "violet": ret *= 10000000; break;
            case "grey": ret *= 100000000; break;
            case "white": ret *= 1000000000; break;
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
