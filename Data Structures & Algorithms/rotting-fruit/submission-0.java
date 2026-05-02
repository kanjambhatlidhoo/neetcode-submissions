class Pair{
    int r, c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int rows, cols;

        rows = grid.length;
        cols = grid[0].length;
        
        Queue<Pair> rottenOranges = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Pair(i, j));
                }
            }
        }

        Pair delim = new Pair(-1, -1);

        rottenOranges.add(delim);

        int time = 0;

        while (!rottenOranges.isEmpty()) {

            if (rottenOranges.peek() == delim) {
                rottenOranges.remove();

                if (!rottenOranges.isEmpty()) {
                    rottenOranges.add(delim);
                    time++;
                }
            } else {
                while (rottenOranges.peek() != delim) {
                    Pair curr = rottenOranges.remove();

                    int []row = {-1, 1, 0, 0};
                    int []col = {0, 0, -1, 1};

                    for (int i = 0; i < 4; i++) {
                        int new_r = curr.r + row[i];
                        int new_c = curr.c + col[i];

                        if (this.isValid(new_r, new_c, rows, cols, grid)) {
                            rottenOranges.add(new Pair(new_r, new_c));
                            grid[new_r][new_c] = 2;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    private boolean isValid(int r, int c, int rows, int cols, int[][] grid) {
        return (r >= 0 && r < rows) && (c >= 0 && c < cols) 
        && grid[r][c] == 1;
    }
}
