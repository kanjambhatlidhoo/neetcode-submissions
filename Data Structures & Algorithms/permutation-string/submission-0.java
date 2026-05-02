class Solution {
    public boolean checkInclusion(String s1, String s2) {
        String sortedS1 = s1.chars()
            .sorted()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());
        
        int n = sortedS1.length();

        int start = 0;
        int end = n - 1;

        while (end < s2.length()) {
            String temp = s2.substring(start, end + 1);

            if (check(sortedS1, temp)) {
                return true;
            }

            else {
                start++;
                end++;
            }
        }

        return false;
    }

    boolean check(String s1, String s2) {
        String sortedS2 = s2.chars()
            .sorted()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());

        return s1.equals(sortedS2);
    }

}
