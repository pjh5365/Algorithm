import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        Tree root = makeTree(nodeinfo);
        ArrayList<Integer> ret1 = new ArrayList<>();
        ArrayList<Integer> ret2 = new ArrayList<>();
        
        preOrder(root, ret1);
        postOrder(root, ret2);
        
        int[][] ret = new int[2][nodeinfo.length];
        ret[0] = ret1.stream().mapToInt(Integer::intValue).toArray();
        ret[1] = ret2.stream().mapToInt(Integer::intValue).toArray();
        return ret;
    }
    
    static void preOrder(Tree now, ArrayList<Integer> ret) {
        if (now == null) {
            return;
        }
        ret.add(now.num);
        preOrder(now.l, ret);
        preOrder(now.r, ret);
    }
    
    static void postOrder(Tree now, ArrayList<Integer> ret) {
        if (now == null) {
            return;
        }
        postOrder(now.l, ret);
        postOrder(now.r, ret);
        ret.add(now.num);
    }
    
    static Tree makeTree(int[][] arr) {
        Tree[] trees = new Tree[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            trees[i] = new Tree(arr[i][0], arr[i][1], i + 1);
        }
        
        Arrays.sort(trees, (o1, o2) -> {
            if (o1.y == o2.y) return Integer.compare(o1.x, o2.x); // Y가 같다면 X기준 오름차순
            return Integer.compare(o2.y, o1.y); // Y 기준으로 내림차순
        });
        
        for (int i = 1; i < trees.length; i++) {
            Tree p = trees[0]; // 시작은 항상 루트에서
            
            while (true) {
                if (trees[i].x < p.x) { // 부모 노드의 X 좌표가 더 크다면 왼쪽
                    if (p.l == null) {
                        p.l = trees[i];
                        break;
                    } else {
                        p = p.l;
                    }
                } else { // 부모 노드의 X 좌표가 더 작거나 같으면 오른쪽
                    if (p.r == null) {
                        p.r = trees[i];
                        break;
                    } else {
                        p = p.r;
                    }
                }
            }
        }
        
        return trees[0];
    }
    
    static class Tree {
        int x;
        int y;
        int num;
        Tree l;
        Tree r;
        
        public Tree(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}