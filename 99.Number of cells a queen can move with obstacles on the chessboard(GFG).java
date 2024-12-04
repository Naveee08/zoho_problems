import java.util.HashSet;

public class QueenMoves {

    // Function to check if the position is within bounds
    public static boolean withinBounds(int n, int x, int y) {
        return x > 0 && x <= n && y > 0 && y <= n;
    }

    // Function to calculate moves in one direction
    public static int calculateMoves(int n, int x, int y, int dx, int dy, HashSet<String> obstacles) {
        int moves = 0;

        // Iterate in the given direction
        while (withinBounds(n, x, y) && !obstacles.contains(x + "," + y)) {
            x += dx; // Move in the x direction
            y += dy; // Move in the y direction
            moves++; // Increment the move count
        }

        return moves; // Return total moves in this direction
    }

    // Function to calculate all possible moves for the queen
    public static int calculateQueenMoves(int n, int k, int queenX, int queenY, int[] obstX, int[] obstY) {
        // Store obstacles as strings in a HashSet for efficient lookup
        HashSet<String> obstacles = new HashSet<>();
        for (int i = 0; i < k; i++) {
            obstacles.add(obstX[i] + "," + obstY[i]);
        }

        int totalMoves = 0;

        // All 8 possible directions the queen can move
        int[][] directions = {
            {1, 0},  // Up
            {-1, 0}, // Down
            {0, 1},  // Right
            {0, -1}, // Left
            {1, 1},  // Diagonal Up-Right
            {1, -1}, // Diagonal Up-Left
            {-1, 1}, // Diagonal Down-Right
            {-1, -1} // Diagonal Down-Left
        };

        // Calculate moves for each direction
        for (int[] dir : directions) {
            totalMoves += calculateMoves(n, queenX + dir[0], queenY + dir[1], dir[0], dir[1], obstacles);
        }

        return totalMoves; // Return total moves
    }

    public static void main(String[] args) {
        int n = 8; // Chessboard size
        int k = 1; // Number of obstacles
        int queenX = 4; // Queen's x position
        int queenY = 4; // Queen's y position
        int[] obstX = {3}; // Obstacles' x positions
        int[] obstY = {5}; // Obstacles' y positions

        // Calculate and print the result
        System.out.println("Number of valid moves: " +
                calculateQueenMoves(n, k, queenX, queenY, obstX, obstY));
    }
}
