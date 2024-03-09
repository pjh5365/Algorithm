import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, h+1);

        tree = new int[treeSize];

        // 참고 : https://cocoon1787.tistory.com/433

        insertTree(1, N, 1);
        sb.append("<");
        int first = get(1, N, K, 1);
        sb.append(first);
        update(1, N, first, 1);
        int index = K;
        for(int i = 1; i < N; i++) {
            int size = N - i;
            index += (K-1);

            index %= size;
            if(index == 0)
                index = size;

            int result = get(1, N, index, 1);
            update(1, N, result, 1);
            sb.append(", ").append(result);
        }
        sb.append(">");
        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static void insertTree(int start, int end, int node) {
        if(start == end)
            tree[node] = 1;
        else {
            insertTree(start, (start+end)/2, node*2);
            insertTree((start+end)/2+1, end, node*2+1);
            tree[node] = tree[node*2] + tree[node*2+1];
        }
    }

    static int get(int start, int end, int index, int node) {
        if(start == end)
            return start;

        else if(index <= tree[node*2])
            return get(start, (start+end)/2, index, node*2);
        else
            return get((start+end)/2+1, end, index-tree[node*2], node*2+1);
    }

    static void update(int start, int end, int index, int node) {
        tree[node]--;
        if(start == end)
            return;
        else {
            if(index <= (start+end)/2)
                update(start, (start+end)/2, index, node*2);
            else
                update((start+end)/2+1, end, index, node*2+1);
        }
    }
}