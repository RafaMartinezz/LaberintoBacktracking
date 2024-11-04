import java.util.Scanner;

/**
 * Main class to solve a maze problem using recursion.
 * The program reads multiple mazes from input, where each maze is represented
 * by a grid.
 * The objective is to find a path from the starting position (top-left) to the
 * target (cheese).
 */
public class Main {

    /**
     * Recursively searches for a solution in a maze starting from a given position.
     * Marks visited positions and prints the path once the target ('Q' for cheese)
     * is found.
     *
     * @param i         The current row position in the maze.
     * @param j         The current column position in the maze.
     * @param laberinto The 2D character array representing the maze.
     * @param sol       The solution path as a string of coordinates.
     * @return true if the solution is found, false otherwise.
     */
    static boolean buscarSolucion(int i, int j, char[][] laberinto, String sol) {
        // Check if out of bounds
        if (i < 0 || i >= laberinto.length || j < 0 || j >= laberinto[i].length) {
            return false;
        }
        // Check if the current cell is a wall
        if (laberinto[i][j] == '#') {
            return false;
        }
        // Check if the cell has been visited
        if (laberinto[i][j] == '.') {
            return false;
        }
        // Check if the cell is the target ('Q' for cheese)
        if (laberinto[i][j] == 'Q') {
            System.out.println(sol + "(" + i + "," + j + ")");
            return true;
        }

        // Mark the cell as visited
        laberinto[i][j] = '.';

        // Add current position to the solution path
        sol = sol + "(" + i + "," + j + ")";

        // Recursively explore adjacent cells: up, left, right, down
        buscarSolucion(i - 1, j, laberinto, sol); // up
        buscarSolucion(i, j - 1, laberinto, sol); // left
        buscarSolucion(i, j + 1, laberinto, sol); // right
        buscarSolucion(i + 1, j, laberinto, sol); // down

        // Backtrack: unmark the cell as visited
        laberinto[i][j] = '0';

        return false;
    }

    /**
     * Main method that reads multiple mazes, finds solutions, and prints each
     * solution path.
     * Each maze consists of cells, where '#' represents walls, '0' represents open
     * paths,
     * and 'Q' represents the target.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLaberinto = 1;

        // Process each maze until there is no more input
        while (scanner.hasNext()) {
            int F = scanner.nextInt(); // Number of rows
            int C = scanner.nextInt(); // Number of columns
            scanner.nextLine();

            // Initialize the maze with the specified dimensions
            char[][] laberinto = new char[F][C];
            for (int i = 0; i < laberinto.length; i++) {
                laberinto[i] = scanner.nextLine().toCharArray(); // Read each row
            }

            // Print the maze identifier and attempt to find a solution
            System.out.println("laberinto " + numLaberinto + ":");
            buscarSolucion(0, 0, laberinto, ""); // Start the search from the top-left corner
            numLaberinto++;
        }
        scanner.close();
    }
}
