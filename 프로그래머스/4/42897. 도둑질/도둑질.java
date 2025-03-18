class Solution {
    static int[] len = new int[] {2, 3}; 
    public int solution(int[] money) {
        boolean[] house = new boolean[money.length];
        int[] mo = new int[money.length];
        mo[0] = money[0];
        for (int i = 0; i < money.length-1; i++) {
            if ((i+2) < (money.length - 1))
                mo[i+2] = Math.max(mo[i+2], money[i+2] + mo[i]);
            if ((i+3) < (money.length - 1))
                mo[i+3] = Math.max(mo[i+3], money[i+3] + mo[i]);
        }
        int num1 = Math.max(mo[money.length - 2], mo[money.length - 3]);
        int[] MO = new int[money.length];
        MO[1] = money[1];
        for (int i = 1; i < money.length; i++) {
            if ((i+2) < money.length)
                MO[i+2] = Math.max(MO[i+2], money[i+2] + MO[i]);
            if ((i+3) < money.length)
                MO[i+3] = Math.max(MO[i+3], money[i+3] + MO[i]);
        }
        int num2 = Math.max(MO[money.length - 2], MO[money.length - 1]);
        
        int[] MOO = new int[money.length];
        MOO[2] = money[2];
        for (int i = 2; i < money.length; i++) {
            if ((i+2) < money.length)
                MOO[i+2] = Math.max(MOO[i+2], money[i+2] + MOO[i]);
            if ((i+3) < money.length)
                MOO[i+3] = Math.max(MOO[i+3], money[i+3] + MOO[i]);
        }
        int num3 = Math.max(MOO[money.length - 2], MOO[money.length - 1]);
        int answer = Math.max(Math.max(num1, num2), num3);
        return answer;
    }
}