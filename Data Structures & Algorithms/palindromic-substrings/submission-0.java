class Solution {
    int count;

    public int countSubstrings(String s) {
        this.count = s.length();

        for (int i = 0; i < s.length(); i++) {
            //for odd and even length palindromes.
            this.palindrome(s, i-1, i+1);
            this.palindrome(s, i-1, i);
        }

        return this.count;
    }

    private void palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            } else {
                this.count++;
                l--;
                r++;
            }
        }
    }
}
