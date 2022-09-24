package 타겟넘버;

class Solution {
    static int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, target, numbers, 0);
        return count;
    }

    private void dfs(int depth, int target, int[] numbers, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(depth + 1, target, numbers, sum + numbers[depth]);
        dfs(depth + 1, target, numbers, sum - numbers[depth]);
    }
}