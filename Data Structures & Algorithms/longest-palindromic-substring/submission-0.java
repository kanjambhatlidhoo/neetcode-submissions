class Pair {
    int start, end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        Pair maxLength = new Pair(0, 0);

        for (int idx = 0; idx < s.length(); idx++) {
            // get even and odd length palindromic substring indices.
            Pair odd = this.palindrome(s, idx - 1, idx + 1);
            Pair even = this.palindrome(s, idx - 1, idx);

            if ((odd.end - odd.start + 1) >= (even.end - even.start + 1)) {
                if ((odd.end - odd.start + 1) > (maxLength.end - maxLength.start + 1)) {
                    maxLength.start = odd.start;
                    maxLength.end = odd.end;
                }
            }

            else if ((even.end - even.start + 1) >= (odd.end - odd.start + 1)) {
                if ((even.end - even.start + 1) > (maxLength.end - maxLength.start + 1)) {
                    maxLength.start = even.start;
                    maxLength.end = even.end;
                }
            }
        }

        return s.substring(maxLength.start, maxLength.end);
    }

    private Pair palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            } else {
                l--;
                r++;
            }
        }

        return new Pair(l+1, r);
    }
}
