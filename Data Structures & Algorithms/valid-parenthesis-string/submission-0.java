class Pair {
    char c;
    int idx;

    Pair (char c, int idx) {
        this.c = c;
        this.idx = idx;
    }
}


class Solution {
    public boolean checkValidString(String s) {
        Stack<Pair> left = new Stack<>();
        Stack<Pair> star = new Stack<>();
        Stack<Pair> right = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(new Pair('(', i));
            } else if (s.charAt(i) == '*') {
                star.push(new Pair('*', i));
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!left.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            } else {
                Pair currLeft = left.pop();
                Pair currStar = star.pop();

                if (currLeft.idx > currStar.idx) {
                    return false;
                }
            }
        }

        return true;
    }
}
