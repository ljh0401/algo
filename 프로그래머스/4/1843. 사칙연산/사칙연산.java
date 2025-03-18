class Solution {
    static String arr[];
    public int solution(String arr[]) {
        this.arr = arr;
        int what = -Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("-")) {
                what = Math.max(what, answer-min(i+1));
                answer -= Integer.parseInt(arr[i+1]);
                i = i+1;
            }
            else if (arr[i].equals("+")) {
                continue;
            }
            else {
                answer += Integer.parseInt(arr[i]);
            }
        }
        what = Math.max(what, answer);
        return what;
    }
    
    public int min(int idx) {
        int sum = 0;
        for (int i = idx; i < arr.length; i++) {
            if(arr[i].equals("-")) {
                int [] nums = max(i+1);
                sum -= nums[0];
                i = nums[1];
            }
            else if (arr[i].equals("+")) {
                continue;
            }
            else {
                sum += Integer.parseInt(arr[i]);
            }
        }
        return sum;
    }
    
    public int[] max(int idx) {
        int sum = 0;
        for (int i = idx; i < arr.length; i++) {
            if(arr[i].equals("-")) {
                int[] r = new int[] {sum, i-1};
                return r;
            }
            else if (arr[i].equals("+")) {
                continue;
            }
            else {
                sum += Integer.parseInt(arr[i]);
            }
        }
        int[] a = new int[] {sum, arr.length-1};
        return a;
    }
}