class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int total = 0;

        int resIdx = 0;

        for (int i = 0; i < gas.length; i++) {
            total = total + (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                resIdx = i + 1;
            }
        }

        return resIdx;
    }
}
