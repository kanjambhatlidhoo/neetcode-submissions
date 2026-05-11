class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        List<Integer> curr = new ArrayList<>();

        this.go(candidates, target, 0, curr, res);
        
        return res;
    }

    void go(int []candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            List<Integer> temp = curr.stream().collect(Collectors.toList());
            res.add(temp);
            return ;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (i > idx && candidates[i] == candidates[i-1]) {
                continue;
            } // duplicate

            curr.add(candidates[i]);
            go(candidates, target - candidates[i], i + 1, curr, res);
            curr.remove(curr.size() - 1); 
        }
    }
}
