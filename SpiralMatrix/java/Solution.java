import java.util.*;

enum Direction {RIGHT, LEFT, UP, DOWN}

public class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
	List<Integer> spiralOrder = new ArrayList<>();
	if(matrix == null || matrix.length == 0) {
	    return spiralOrder;
	}

	Direction curDirection = Direction.RIGHT;
	Map<Direction, Integer> dirToBoundary = new HashMap<>();
	dirToBoundary.put(Direction.RIGHT, matrix[0].length - 1);
	dirToBoundary.put(Direction.DOWN, matrix.length - 1);
	dirToBoundary.put(Direction.UP, 0);
	dirToBoundary.put(Direction.LEFT,0);

	int i = 0, j = 0;
	while(spiralOrder.size() < matrix.length * matrix[0].length) {
	    int boundary = dirToBoundary.get(curDirection);
	    Direction dirToUpdate = getDirectionToUpdate(curDirection);
	    int boundaryToUpdate = dirToBoundary.get(dirToUpdate);
	    if(curDirection == Direction.RIGHT) {
		while(j <= boundary) {
		    spiralOrder.add(matrix[i][j]);
		    j++;
		}
		j--;
		i++;
		dirToBoundary.put(dirToUpdate, boundaryToUpdate + 1);
	    }
	    else if(curDirection == Direction.DOWN) {
		while(i <= boundary) {
		    spiralOrder.add(matrix[i][j]);
		    i++;
		}
		i--;
		j--;
		dirToBoundary.put(dirToUpdate, boundaryToUpdate - 1);
	    }
	    else if(curDirection == Direction.LEFT) {
		while(j >= boundary) {
		    spiralOrder.add(matrix[i][j]);
		    j--;
		}
		j++;
		i--;
		dirToBoundary.put(dirToUpdate, boundaryToUpdate - 1);
	    }
	    else {//Direction.UP
		while(i >= boundary ) { 
		    spiralOrder.add(matrix[i][j]);
		    i--;
		}
		i++;
		j++;
		dirToBoundary.put(dirToUpdate, boundaryToUpdate + 1);
	    }
	    curDirection = getNewDirection(curDirection);
	}
	return spiralOrder;
    }

    private Direction getDirectionToUpdate(Direction curDirection) {
	switch(curDirection) {
	case RIGHT:
	    return Direction.UP;
	case DOWN:
	    return Direction.RIGHT;
	case LEFT:
	    return Direction.DOWN;
	case UP:
	    return Direction.LEFT;
	default:
	    throw new RuntimeException("Invalid direction");
	}
    }

    private Direction getNewDirection(Direction oldDirection) {
	switch(oldDirection) {
	case RIGHT:
	    return Direction.DOWN;
	case DOWN:
	    return Direction.LEFT;
	case LEFT:
	    return Direction.UP;
	case UP:
	    return Direction.RIGHT;
	default:
	    throw new RuntimeException("Invalid direction");
	}
    }

    public static void main(String[] args) {
	int[][] matrix = {
	    {1,2,3},
	    {4,5,6},
	    {7,8,9}
	};
	Solution s = new Solution();
	System.out.println(s.spiralOrder(matrix));
    }
}

