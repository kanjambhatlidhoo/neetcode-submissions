class Pair{
    int x,y,z;

    Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        ArrayList<Pair> valid = new ArrayList<>();

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                valid.add(new Pair(triplets[i][0], triplets[i][1], triplets[i][2]));
            }
        }
        
        boolean contains1 = false; 
        boolean contains2 = false;
        boolean contains3 = false;

        for (Pair curr : valid) {
            if (curr.x == target[0]) {
                contains1 = true;
            }

            if (curr.y == target[1]) {
                contains2 = true;
            }

            if (curr.z == target[2]) {
                contains3 = true;
            }

            if (contains1 && contains2 && contains3) {
                return true;
            }
        }

        return false;

    }
}
