class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int now = health;
        int count = 0;
        int time = 0;
        int lastTime = attacks[attacks.length - 1][0];
        int index = 0;
        while (time <= lastTime) {
            if (time == attacks[index][0]) {
                now -= attacks[index][1];
                count = 0;
                index++;
            } else {
                count++;
                if (now < health) {
                    if (count == bandage[0]) {
                        now += bandage[1] + bandage[2];
                        count = 0;
                        if (now > health) {
                            now = health;
                        }
                    } else {
                        now += bandage[1];
                        if (now > health) {
                            now = health;
                        }
                    }
                }
            }
            if (now <= 0) {
                return -1;
            }
            time++;
        }
        if (now <= 0) {
            return -1;
        }
        return now;
    }
}