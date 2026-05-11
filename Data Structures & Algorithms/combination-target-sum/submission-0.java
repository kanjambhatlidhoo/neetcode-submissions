class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        this.go(nums, target, 0, curr, res);

        return res;
    }

    void go(int []nums, int target, int idx, List<Integer> curr,  List<List<Integer>> res) {
        
        if (target == 0) {
            List<Integer> temp = curr.stream().collect(Collectors.toList());
            res.add(temp);

            return ;
        }
        
        if (idx == nums.length) {
            return ;
        }

        if (target < 0) {
            return ;
        }

        //two cases: either take the same element or move ahead.
        curr.add(nums[idx]);
        go(nums, target - nums[idx], idx, curr, res);
        curr.remove(curr.size() - 1);

        go(nums, target, idx + 1, curr, res);
    }
}
