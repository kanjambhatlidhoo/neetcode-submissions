class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        go(nums, 0, curr, res);

        return res;

    }

    void go(int []nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        res.add(curr.stream().collect(Collectors.toList()));

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);

            go(nums, i + 1, curr, res);

            curr.remove(curr.size() - 1);
        }


    }
}
