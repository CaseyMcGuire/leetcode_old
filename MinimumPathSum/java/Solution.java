public class Solution {

    public int minPathSum(int[][] grid) {

	//double array so we can avoid integer overflow and fill array with infinity values
        double[][] newGrid = new double[grid.length][grid[0].length];

	//Fill our new grid with inifinities so any possible integer value will be less than it
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++){
                newGrid[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        newGrid[0][0] = grid[0][0];

	//go through grid, determining whether the new path for any possible location beats the
	//previous path
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(i != grid.length - 1 && newGrid[i+1][j] > grid[i+1][j] + newGrid[i][j]) {
                    newGrid[i+1][j] = grid[i+1][j] + newGrid[i][j];
                }
                if(j != grid[i].length - 1 && newGrid[i][j+1] > grid[i][j+1] + newGrid[i][j]) {
                    newGrid[i][j+1] = grid[i][j+1] + newGrid[i][j];
                }
            }
        }
        return (int)newGrid[newGrid.length - 1][newGrid[0].length - 1];
    }
}
