import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Tree root = new Tree(-1);
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            if (root.root == -1) {
                root.root = n;
            } else {
                root.add(n);
            }
        }
        root.print();
        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static class Tree {
        int root;
        Tree left;
        Tree right;

        public Tree(int root) {
            this.root = root;
            this.left = null;
            this.right = null;
        }

        public void add(int n) {
            if (n > root) {
                if (this.right == null) {
                    this.right = new Tree(n);
                } else {
                    this.right.add(n);
                }
            } else {
                if (this.left == null) {
                    this.left = new Tree(n);
                } else {
                    this.left.add(n);
                }
            }
        }

        public void print() {
            if (root == -1) {
                return;
            }
            if (left != null) {
                left.print();
            }
            if (right != null) {
                right.print();
            }
            sb.append(root).append("\n");
        }
    }
}
