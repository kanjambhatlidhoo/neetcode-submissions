class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> map = new HashSet<>(wordDict);
        Boolean []memo = new Boolean[s.length()];

        return dfs(s, 0, map, memo);
    }

    private boolean dfs(String s, int start, Set<String> map, Boolean []memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (map.contains(word) && dfs(s, end, map, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        
        memo[start] = false;
        return memo[start];
    }
}
